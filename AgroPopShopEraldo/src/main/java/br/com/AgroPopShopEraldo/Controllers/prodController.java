package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.Repositories.agroRepository;
import br.com.AgroPopShopEraldo.Repositories.produtoRepository;
import br.com.AgroPopShopEraldo.model.Cliente;
import br.com.AgroPopShopEraldo.produto.Produto;

@Controller
public class prodController {
	@Autowired
	produtoRepository produtoRepo;
	@Autowired
	agroRepository agroRepo;

	
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
	@GetMapping("/edit/{idp}")
	public ModelAndView formEditarProduto(@PathVariable("idp") long id) {
		Produto produto = produtoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView modelAndView = new ModelAndView("editarProdutos");
		modelAndView.addObject(produto);
		return modelAndView;
	}
	@PostMapping("/edit/{idp}")
	public ModelAndView editarProdutos(@PathVariable("idp") long id, Produto p) {
		this.produtoRepo.save(p);
		return new ModelAndView("redirect:/listarProdutos");
	}
	@GetMapping("/remove/{idp}")
	public ModelAndView removerProduto(@PathVariable("idp") long id) {
		Produto aRemover = produtoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		produtoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarProdutos");
	}
	//PEDIDO//
	@GetMapping("/cadastrarPedido/{idPedido}")
	public ModelAndView cadastrarPedido (@PathVariable("id") long id) {
		Cliente cliente = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView mav = new ModelAndView("cadastrarPedido");
		mav.addObject(new Produto());
		mav.addObject(cliente);
		return mav;
	}
}
