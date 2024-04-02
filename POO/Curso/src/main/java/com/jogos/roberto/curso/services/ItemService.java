package com.jogos.roberto.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.roberto.curso.entities.Item;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private JogoService jogoService;

	public Item buscarPorId(Long id_item) {
		return itemRepository.buscarPorId(id_item);
	}
	/*
	public Item adicionarItem(Item item) {
        return itemRepository.save(item);
    }*/
	
	public boolean adicionarItem(Item item) {
		Jogo jogoExistente = jogoService.buscarPorNome(item.getJogo().getNome());
		if (jogoExistente == null) {
			return false;
		}

		item.setJogo(jogoExistente);
		itemRepository.saveAndFlush(item);
		return true;
	}

	public boolean atualizarItem(Long id_item, Jogo jogo, int quantidade) {
		Item itemExistente = buscarPorId(id_item);
		if (itemExistente == null) {
			return false;
		}
		
		if (!itemExistente.getJogo().getNome().equals(jogo.getNome())) {
			itemExistente.setJogo(jogo);			
		}
		if (itemExistente.getQuantidade() != quantidade) {
			itemExistente.setQuantidade(quantidade);			
		}
		itemRepository.saveAndFlush(itemExistente);
		return true;
	}

	public boolean deletarItem(Long id_item) {
		Item itemExistente = buscarPorId(id_item);
		if (itemExistente != null) {
			itemRepository.delete(itemExistente);
			return true;
		}
		return false;
	}

}
