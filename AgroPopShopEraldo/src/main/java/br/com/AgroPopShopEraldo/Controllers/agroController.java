package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/cadastrarClientes")
	public String cadastrarClientes(Cliente c) {
		this.agroRepo.save(c);
		return "redirect:/listarClientes";

	}
	@GetMapping("/editar/{id}")
	public ModelAndView formEditarCliente(@PathVariable("id") long id) {
		Cliente cliente = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView modelAndView = new ModelAndView("editarClientes");
		modelAndView.addObject(cliente);
		return modelAndView;
	}
	@PostMapping("/editar/{id}")
	public ModelAndView editarClientes(@PathVariable("id") long id, Cliente c) {
		this.agroRepo.save(c);
		return new ModelAndView("redirect:/listarClientes");
	}
	@GetMapping("/remover/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id) {
		Cliente aRemover = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		agroRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarClientes");
	}
	
}
