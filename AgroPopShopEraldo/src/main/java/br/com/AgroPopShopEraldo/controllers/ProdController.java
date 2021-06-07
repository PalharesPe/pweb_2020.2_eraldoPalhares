package br.com.AgroPopShopEraldo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.model.Produto;
import br.com.AgroPopShopEraldo.repositories.AgroRepository;
import br.com.AgroPopShopEraldo.repositories.ProdutoRepository;

@Controller
public class ProdController {
	@Autowired
	ProdutoRepository produtoRepo;
	@Autowired
	AgroRepository agroRepo;

	@GetMapping("/listarProdutos")
	public ModelAndView listarProdutos() {
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView mav = new ModelAndView("listarProdutos");
		mav.addObject("produtos", lista);
		return mav;
	}

	@GetMapping("/cadastrarProdutos")
	public ModelAndView formCadastrarProdutos() {
		ModelAndView modelAndView = new ModelAndView("cadastrarProdutos");
		modelAndView.addObject(new Produto());
		return modelAndView;
	}

	@PostMapping("/cadastrarProdutos")
	public String cadastrarProdutos(Produto p) {
		this.produtoRepo.save(p);
		return "redirect:/listarProdutos";
	}

	// Editar /Remover//
	@GetMapping("/editarprod/{id}")
	public ModelAndView formEditarProduto(@PathVariable("id") long id) {
		Produto produto = produtoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView modelAndView = new ModelAndView("editarProdutos");
		modelAndView.addObject(produto);
		return modelAndView;
	}

	@PostMapping("/editarprod/{id}")
	public ModelAndView editarProdutos(@PathVariable("id") long id, Produto p) {
		this.produtoRepo.save(p);
		return new ModelAndView("redirect:/listarProdutos");
	}

	@GetMapping("/removerprod/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Produto aRemover = produtoRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		produtoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarProdutos");
	}

}
