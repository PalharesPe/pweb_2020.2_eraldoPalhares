package br.com.eraldo.cadpessoas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eraldo.cadpessoas.repositorys.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepo;
	
	@GetMapping
	public String index() {
		return "index.html";
	}

}
