package com.example.estoque.service;

import com.example.estoque.model.Produto;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Produto atualizarQuantidade(Long id, int novaQuantidade) {
        Produto produto = repository.findById(id).orElseThrow();
        produto.setQuantidade(novaQuantidade);
        return repository.save(produto);
    }
}
