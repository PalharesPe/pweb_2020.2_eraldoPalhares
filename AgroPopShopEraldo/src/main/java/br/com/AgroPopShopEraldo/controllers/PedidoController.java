package br.com.AgroPopShopEraldo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.pedido.Pedido;
import br.com.AgroPopShopEraldo.repositories.PedidoRepository;
import br.com.AgroPopShopEraldo.repositories.ProdutoRepository;

@Controller
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepo;
	@Autowired
	ProdutoRepository produtoRepo;

	
	
	
	//Cadastrar o Pedido//
	@PostMapping("/cadastrarPedido")
	public String cadastrarPedido (Pedido p) {
		this.pedidoRepo.save(p);
		return "redirect:/listarClientes";
	}
	
	@GetMapping("/removerpedido/{id}")
	public ModelAndView removerPedido(@PathVariable("id") long id) {
		Pedido pRemover = pedidoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		pedidoRepo.delete(pRemover);
		return new ModelAndView("redirect:/listarPedidos/{id}");
	}
}