package com.example.estoque.controller;

import com.example.estoque.model.Produto;
import com.example.estoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}/quantidade")
    public Produto atualizarQuantidade(@PathVariable Long id, @RequestParam int novaQuantidade) {
        return service.atualizarQuantidade(id, novaQuantidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
