package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.Repositories.agroRepository;
import br.com.AgroPopShopEraldo.model.Cliente;

@Controller
@RequestMapping("/")
public class agroController {
	@Autowired
	agroRepository agroRepo;

	@GetMapping
	public String index() {
		return "index.html";
	}

	//OK//
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		List<Cliente> lista = agroRepo.findAll();
		ModelAndView mav = new ModelAndView("listarClientes");
		mav.addObject("clientes", lista);
		return mav;
	}
	@GetMapping("/cadastrarClientes")
	public ModelAndView formCadastrarClientes() {
		ModelAndView modelAndView = new ModelAndView("cadastrarClientes");
		modelAndView.addObject(new Cliente());
		return modelAndView;
	}
}
