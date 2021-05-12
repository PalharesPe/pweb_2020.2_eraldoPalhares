package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.Repositories.pedidoRepository;
import br.com.AgroPopShopEraldo.Repositories.produtoRepository;
import br.com.AgroPopShopEraldo.pedido.Venda;

@Controller
public class pedidoController {

	@Autowired
	pedidoRepository pedidoRepo;

	@Autowired
	produtoRepository produtoRepo;

		
	@GetMapping("/listarPedidos")
	public ModelAndView listarPedidos() {
		List<Venda> lista = pedidoRepo.findAll();
		ModelAndView mav = new ModelAndView("listarPedidos");
		mav.addObject("venda", lista);
		return mav;
	}

	@PostMapping("/cadastrarPedido")
	public String adicionarPedido (Venda S) {
		this.pedidoRepo.save(S);
		return "redirect:/listarPedidos";
	}
	@GetMapping("/removerpedido{id}")
	public ModelAndView removerPedido(@PathVariable("id") long id) {
		Venda aRemover = pedidoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		pedidoRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarPedidos");
	}
}
