package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	
	/*Metodos disparados depois de uma requisicao http*/
	/*
	@RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "Hello Spring Boot!" ;
	}
	*/
	
	/*Pode passar mais de um caminho par esse método*/
	@GetMapping(path = {"/ola", "/saudacao"})
	public String ola() {
		return "Hello Spring Boot!" ;
	}
	
	/*Mapeando com metodo http diferente*/
	@PostMapping(path = {"/ola", "/saudacao"})
	public String saudacao() {
		return "Hello Spring Boot (POST)!" ;
	}
	
	

}
