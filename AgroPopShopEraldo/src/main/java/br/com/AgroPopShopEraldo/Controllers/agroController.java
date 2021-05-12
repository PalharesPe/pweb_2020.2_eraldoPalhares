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
import br.com.AgroPopShopEraldo.Repositories.dependRepository;
import br.com.AgroPopShopEraldo.model.Cliente;
import br.com.AgroPopShopEraldo.model.Dependente;
import br.com.AgroPopShopEraldo.pedido.Venda;

@Controller
@RequestMapping("/")
public class agroController {
	@Autowired
	agroRepository agroRepo;
	@Autowired
	dependRepository depRepo;

	@GetMapping
	public String index() {
		return "index.html";
	}

	//CRUD//
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
		Dependente dRemover = depRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		depRepo.delete(dRemover);
		agroRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarClientes");
	}
	
	
	//DEPENDENTE//
	@GetMapping("/cadastrarDependente/{id}")
	public ModelAndView cadastrarDependente (@PathVariable("id") long id) {
		Cliente cliente = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView mav = new ModelAndView("cadastrarDependente");
		mav.addObject(new Dependente());
		mav.addObject(cliente);
		return mav;
	}
	//PEDIDO//
	@GetMapping("/cadastrarPedido/{id}")
	public ModelAndView cadastrarPedido(@PathVariable("id") long id) {
		Cliente cliente = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView mav = new ModelAndView("cadastrarPedido");
		mav.addObject(new Venda());
		mav.addObject(cliente);
		return mav;
	}
	
	//Lista Cliente e Dependente//
	@GetMapping("infoClientes/{id}")
	public ModelAndView infoCLiente(@PathVariable("id") long id) {
	List<Dependente> listad = depRepo.findByIdPrincipal(id);
	Cliente cliente = agroRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
	ModelAndView mav = new ModelAndView("infoClientes");
	mav.addObject("dependente", listad);
	mav.addObject(cliente);
	return mav;
}
	
}
