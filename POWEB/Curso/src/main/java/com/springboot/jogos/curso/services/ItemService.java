package com.springboot.jogos.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jogos.curso.entities.Item;
import com.springboot.jogos.curso.entities.Jogo;
import com.springboot.jogos.curso.repositories.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private JogoService jogoService;

    public Item buscarPorId(Long id) {
        return itemRepository.buscarPorId(id);
    }

    public boolean adicionarItem(Item item) {
    	Jogo itemExistente = jogoService.buscarPorNome(item.getJogo().getNome());
    	if (itemExistente != null) {
            itemRepository.save(item);
            return true;
    	}
    	return false;
    }

    public boolean atualizarItem(Long id_item, Jogo jogo, int quantidade, float precoUnitario) {
        Item itemExistente = buscarPorId(id_item);

        if (itemExistente != null) {
            itemExistente.setJogo(jogo);
            itemExistente.setQuantidade(quantidade);
            itemExistente.setPrecoUnitario(precoUnitario);
            itemRepository.save(itemExistente);
            return true;
        }
        return false;

    }

    public boolean deletarItem(Long id_item) {
        Item itemExistente = buscarPorId(id_item);

        if (itemExistente != null) {
            itemRepository.delete(itemExistente);
            return true;
        }
        return false;
    }
    
    public List<Item> listarItens() {
    	return itemRepository.listarItens();
    }
}
