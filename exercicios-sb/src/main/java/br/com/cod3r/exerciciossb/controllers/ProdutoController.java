package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.entities.repositories.ProductRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired /*INTERFACE que faz a PERSISTENCIA no banco de dados - Com essa anotação o spring fica responsavel por criar um objeto desse tipo ProductRepository*/
	private ProductRepository produtoRepository;

	/*CRIACAO DO BANCO DE DADOS*/
	
	/*
	@PostMapping
	public @ResponseBody Produto novoProduto(
			@RequestParam String nome,
			@RequestParam double preco,
			@RequestParam double desconto) {
		Produto produto = new Produto(nome, preco, desconto);
		produtoRepository.save(produto);
		return produto;
	}
	*/
	
	/*PUT para INSERIR e POST para MODIFICAR*/
	//@PostMapping
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	/*OBTER OS DADOS A PARTIR DO BANCO DE DADOS*/
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		return produtoRepository.findAll();
	}

	/* CONSULTANDO PRODUTO POR ID*/
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	/* ALTERANDO PRODUTO #1*/
	
	/*
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	*/

}
