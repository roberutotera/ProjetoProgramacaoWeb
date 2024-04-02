package com.jogos.roberto.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.entities.Cliente;
import com.jogos.roberto.curso.entities.Item;
import com.jogos.roberto.curso.entities.Pedido;
import com.jogos.roberto.curso.repositories.PedidoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private JogoService jogoService;

	public Pedido buscarPorId(Long id_pedido) {
		return pedidoRepository.buscarPorId(id_pedido);
	}

	public List<Pedido> buscarPedidosEmProgresso(Long id_cliente) {
		return pedidoRepository.buscarPedidosEmProgresso(id_cliente);
	}

	public List<Pedido> buscarPedidosDoCliente(Long id_cliente) {
		return pedidoRepository.buscarPedidosDoCliente(id_cliente);
	}
	
	public List<Pedido> buscarPedidosFinalizados(Long id_cliente) {
		return pedidoRepository.buscarPedidosFinalizados(id_cliente);
	}

	public Pedido adicionarPedido(Long id_cliente, String formaPagamento) {
		Cliente clienteExistente = clienteService.buscarPorID(id_cliente);
		if (clienteExistente == null) {
			return null;
		}

		List<Pedido> pedidosEmProgresso = pedidoRepository.buscarPedidosEmProgresso(id_cliente);
		if (!pedidosEmProgresso.isEmpty()) {
			return null;
		}

		Pedido novoPedido = new Pedido(clienteExistente, formaPagamento);
		clienteExistente.adicionarPedido(novoPedido);
		pedidoRepository.saveAndFlush(novoPedido);
		return novoPedido;
	}

	public String atualizarPedido(Long id_pedido, Long id_cliente, float valorTotal, LocalDateTime dataPedido,
			LocalDateTime dataEntrega, String formaPagamento, boolean status) {
		Cliente clienteExistente = clienteService.buscarPorID(id_cliente);
		if (clienteExistente == null) {
			return "Cliente não encontrado.";
		}

		Pedido pedidoExistente = buscarPorId(id_pedido);
		if (pedidoExistente == null || !pedidoExistente.getCliente().getId_cliente().equals(id_cliente)) {
			return "Pedido não encontrado ou não pertence a esse Cliente.";
		}
		if (valorTotal > 0) {
			pedidoExistente.setValorTotal(valorTotal);
		}
		if (dataPedido != null) {
			pedidoExistente.setDataPedido(dataPedido);
		}
		if (dataEntrega != null) {
			pedidoExistente.setDataEntrega(dataEntrega);
		}
		if (!formaPagamento.isEmpty()) {
			pedidoExistente.setFormaPagamento(formaPagamento);
		}
		
		List<Pedido> pedidosEmAberto = pedidoRepository.buscarPedidosEmProgresso(id_cliente);
		if (pedidosEmAberto.isEmpty() || !pedidoExistente.isFinalizado()) {
			pedidoExistente.setFinalizado(status);
		}
		
		pedidoRepository.saveAndFlush(pedidoExistente);
		return "Pedido atualizado com sucesso.";
	}

	public String deletarPedido(Long id_pedido) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente == null) {
			return "Pedido não encontrado.";
		}

		Cliente clienteExistente = pedidoExistente.getCliente();
		if (clienteExistente == null) {
			return "Cliente não encontrado.";
		}

		List<Pedido> pedidosEmProgresso = pedidoRepository.buscarPedidosDoCliente(clienteExistente.getId_cliente());
		if (pedidosEmProgresso.size() == 0) {
			return "O cliente não tem nenhum pedido.";
		}

		List<Item> itensDoPedido = pedidosEmProgresso.get(0).getItens();
		for (Item item : itensDoPedido) {
			itemService.deletarItem(item.getId_item());
		}

		clienteExistente.removerPedido(pedidoExistente);
		pedidoRepository.delete(pedidoExistente);
		return "Pedido deletado com sucesso.";
	}

	public List<Pedido> listarPedidos() {
		return pedidoRepository.listarPedidos();
	}

	public String adicionarItemAoPedido(Long id_pedido, Long id_jogo, int quantidade) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente == null) {
			return "Pedido não encontrado.";
		}

		Jogo jogoExistente = jogoService.buscarPorId(id_jogo);
		if (jogoExistente == null) {
			return "Esse jogo não existe.";
		}

		Item itemExistente = pedidoExistente.getItemByJogoId(id_jogo);
		if (itemExistente != null) {
			itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
			pedidoExistente.setValorTotal(pedidoExistente.getValorTotal() + (jogoExistente.getPreco() * quantidade));
			pedidoRepository.saveAndFlush(pedidoExistente);
			return "Quantidade do item atualizada no pedido.";
		} else {
			Item item = new Item(jogoExistente, quantidade);
			boolean itemAdicionado = itemService.adicionarItem(item);

			if (itemAdicionado) {
				pedidoExistente.adicionarItem(item);
				pedidoRepository.saveAndFlush(pedidoExistente);
				return "Item adicionado ao pedido. ItemId: " + item.getId_item();
			} else {
				return "Erro ao adicionar o item.";
			}
		}
	}

	public String deletarItemDoPedido(Long id_pedido, Long id_item) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente == null) {
			return "Pedido não encontrado.";
		}

		if (pedidoExistente.isFinalizado()) {
			return "Pedido já finalizado.";
		}

		boolean itemExistente = pedidoExistente.getItens().stream().anyMatch(item -> item.getId_item().equals(id_item));

		if (!itemExistente) {
			return "Item não existe no pedido.";
		}

		Item itemParaRemover = itemService.buscarPorId(id_item);

		if (itemParaRemover == null) {
			return "Item não encontrado no pedido.";
		}

		pedidoExistente.removerItem(itemParaRemover);
		itemService.deletarItem(id_item);

		if (pedidoExistente.getItens().isEmpty()) {
			pedidoRepository.delete(pedidoExistente);
			return "Item removido do pedido e pedido fechado.";
		} else {
			pedidoRepository.saveAndFlush(pedidoExistente);
			return "Item removido do pedido com sucesso.";
		}
	}

	public String finalizarPedido(Long id_pedido) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente == null) {
			return "Pedido não encontrado.";
		}

		if (pedidoExistente.isFinalizado()) {
			return "Pedido já finalizado.";
		}

		if (pedidoExistente.getItens().isEmpty()) {
			return "O pedido precisa ter pelo menos 1 item.";
		}

		pedidoExistente.finalizar();
		pedidoRepository.saveAndFlush(pedidoExistente);
		return "Pedido finalizado.";
	}

	public String atualizarItemDoPedido(Long id_pedido, Long id_item, Long novoid_jogo, int novaQuantidade) {
		Pedido pedidoExistente = buscarPorId(id_pedido);

		if (pedidoExistente == null) {
			return "Pedido não encontrado.";
		}

		if (pedidoExistente.isFinalizado()) {
			return "Pedido já finalizado.";
		}

		Item itemExistente = pedidoExistente.getItemById(id_item);

		if (itemExistente == null) {
			return "Item não encontrado no pedido.";
		}

		Jogo novoJogo = null;
		if (novoid_jogo != null) {
			novoJogo = jogoService.buscarPorId(novoid_jogo);
			if (novoJogo == null) {
				return "Livro não encontrado.";
			}
		}

		float precoUnitarioAtual = itemExistente.getJogo().getPreco();
		float novoValorTotal;

		if (novoJogo != null) {
			float precoUnitarioNovo = novoJogo.getPreco();
			float valorDoLivroAnterior = precoUnitarioAtual * itemExistente.getQuantidade();
			float valorDoNovoLivro = precoUnitarioNovo * novaQuantidade;
			itemExistente.setJogo(novoJogo);
			itemExistente.setQuantidade(novaQuantidade);
			novoValorTotal = pedidoExistente.getValorTotal() - valorDoLivroAnterior + valorDoNovoLivro;
		} else {
			int diferencaQuantidade = novaQuantidade - itemExistente.getQuantidade();
			itemExistente.setQuantidade(novaQuantidade);
			novoValorTotal = pedidoExistente.getValorTotal() + (diferencaQuantidade * precoUnitarioAtual);
		}

		pedidoExistente.setValorTotal(novoValorTotal);
		pedidoRepository.saveAndFlush(pedidoExistente);

		return "Item atualizado no pedido.";
	}

	public List<Item> listarItensDoPedido(Long id_pedido) {
		Pedido pedidoExistente = buscarPorId(id_pedido);
		return (pedidoExistente != null) ? pedidoExistente.getItens() : null;
	}

	public List<Jogo> listarJogosDoPedido(Long id_pedido) {
		List<Jogo> listaJogos = new ArrayList<>();
		Pedido pedido = buscarPorId(id_pedido);

		if (pedido != null && !pedido.getItens().isEmpty()) {
			for (Item item : pedido.getItens()) {
				Jogo jogo = item.getJogo();
				if (jogo != null) {
					listaJogos.add(jogo);
				}
			}
		}
		return listaJogos;
	}
}