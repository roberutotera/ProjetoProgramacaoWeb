package com.jogos.roberto.curso.controllers.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jogos.roberto.curso.entities.Item;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.services.ItemService;
import com.jogos.roberto.curso.services.JogoService;
import com.jogos.roberto.curso.services.PedidoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/item")
public class ItemRestController {

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private JogoService jogoService;

    @GetMapping("/{id_item}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id_item) {
        Item item = itemService.buscarPorId(id_item);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    /*
    @PostMapping("/adicionar")
    public ResponseEntity<Item> adicionarItem(@RequestBody Item item) {
        Item newItem = itemService.adicionarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }*/

    @PutMapping("/{id_item}")
    public ResponseEntity<String> atualizarItem(@PathVariable Long id_item,
                                                @RequestBody Item item) {
        if (itemService.atualizarItem(id_item, item.getJogo(), item.getQuantidade())) {
            return ResponseEntity.ok("Item atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id_item}")
    public ResponseEntity<String> deletarItem(@PathVariable Long id_item) {
        if (itemService.deletarItem(id_item)) {
            return ResponseEntity.ok("Item deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
