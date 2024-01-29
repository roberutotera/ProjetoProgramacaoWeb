package com.springboot.jogos.curso.services;

import com.springboot.jogos.curso.entities.Cliente;
import com.springboot.jogos.curso.entities.Item;
import com.springboot.jogos.curso.entities.Pedido;
import com.springboot.jogos.curso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemService itemService;

	public Pedido buscarPorId(Long id_pedido) {
		return pedidoRepository.buscarPorId(id_pedido);
	}

	public String adicionarPedido(Long id_usuario) {
		Cliente clienteExistente = clienteService.buscarCliente(id_usuario);
		if (clienteExistente != null) {
			if (pedidoRepository.buscarPedidosEmProgresso(id_usuario).size() != 0) {
				Pedido novoPedido = new Pedido(clienteService.buscarCliente(id_usuario));
				clienteExistente.adicionarPedido(novoPedido);
				pedidoRepository.save(novoPedido);
				pedidoRepository.flush();
			} else {
				return "Cliente já tem uma compra em progresso.";
			}
		}

		return "Cliente não encontrado.";
	}

	public String atualizarPedido(Long id_pedido, Long id_usuario, float valorTotal, java.sql.Date dataPedido,
        java.sql.Date dataEntrega) {
    Cliente clienteExistente = clienteService.buscarCliente(id_usuario);
    if (clienteExistente != null) {
        Pedido pedidoExistente = buscarPorId(id_pedido);
        if (pedidoExistente != null) {
            if (!pedidoExistente.isFinalizado()) {
                pedidoExistente.setValorTotal(valorTotal);
                pedidoExistente.setDataPedido(dataPedido);
                pedidoExistente.setDataEntrega(dataEntrega);
                pedidoRepository.save(pedidoExistente);
                pedidoRepository.flush();
                return "Pedido atualizado com sucesso.";
            } else {
                return "Compra já finalizada.";
            }
        } else {
            return "Pedido não encontrado.";
        }
    }
    return "Cliente não encontrado.";
}



	public String deletarPedido(Long id_pedido) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente != null) {
			Cliente clienteExistente = pedidoExistente.getCliente();
			if (clienteExistente != null) {
				clienteExistente.removerPedido(pedidoExistente);
				return "Pedido deletado com sucesso.";
			} else {
				return "Cliente não encontrado.";
			}
		} else {
			return "Pedido não encontrado.";
		}
	}

	public List<Pedido> listarPedidos() {
		return pedidoRepository.listarPedidos();
	}

	public String adicionarItemAoPedido(Long id_pedido, Item item) {
        Pedido pedidoExistente = buscarPorId(id_pedido);
    
        if (pedidoExistente != null) {
            boolean itemExistente = itemService.adicionarItem(item);
            if (itemExistente) {
                pedidoExistente.getItens().add(item);
                pedidoRepository.save(pedidoExistente);
                pedidoRepository.flush();
    
                return "Item adicionado ao pedido com sucesso.";
            } else {
                return "Item já adicionado.";
            }
        } else {
            return "Pedido não encontrado.";
        }
    }
	
    public String deletarItemDoPedido(Long id_pedido, Long id_item) {
        Pedido pedidoExistente = buscarPorId(id_pedido);

        if (pedidoExistente != null) {
            if (!pedidoExistente.isFinalizado()) {
                List<Item> itens = pedidoExistente.getItens();
                Item itemParaRemover = null;

                for (Item item : itens) {
                    if (item.getId_item().equals(id_item)) {
                        itemParaRemover = item;
                        break;
                    }
                }

                if (itemParaRemover != null) {
                    itens.remove(itemParaRemover);
                    itemService.deletarItem(id_item);
                    return "Item removido do pedido com sucesso.";
                } else {
                    return "Item não encontrado no pedido.";
                }
            } else {
                return "Compra já finalizada.";
            }
        } else {
            return "Pedido não encontrado.";
        }
    }
}
