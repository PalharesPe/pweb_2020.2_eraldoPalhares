package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.Repositories.agroRepository;
import br.com.AgroPopShopEraldo.Repositories.pedidoRepository;
import br.com.AgroPopShopEraldo.pedido.PedidoVenda;

@Controller
public class pedidoController {

	@Autowired
	pedidoRepository pedidoRepo;

	@Autowired
	agroRepository agroRepo;

	
	
	
	@GetMapping("/listarPedidos")
	public ModelAndView listarClientes() {
		List<PedidoVenda> lista = pedidoRepo.findAll();
		ModelAndView mav = new ModelAndView("listarPedidos");
		mav.addObject("pedido", lista);
		return mav;
	}

	@GetMapping("/cadastrarPedido")
	public ModelAndView formCadastrarPedido() {
		ModelAndView modelAndView = new ModelAndView("cadastrarPedido");
		modelAndView.addObject(new PedidoVenda());
		return modelAndView;
	}/**
		 * @PostMapping("/cadastrarClientes") public String cadastrarClientes(Cliente c)
		 * { this.agroRepo.save(c); return "redirect:/listarClientes";
		 * 
		 * }
		 */

}
