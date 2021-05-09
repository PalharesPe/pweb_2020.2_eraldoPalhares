package br.com.AgroPopShopEraldo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.AgroPopShopEraldo.Repositories.agroRepository;
import br.com.AgroPopShopEraldo.Repositories.dependRepository;
import br.com.AgroPopShopEraldo.model.Dependente;
@Controller
public class dependController {	
	@Autowired
	agroRepository agroRepo;
	@Autowired
	dependRepository depRepo;
	
	
	
	@GetMapping("/listarDependente")
	public ModelAndView listarDependente() {
		List<Dependente> lista = depRepo.findAll();
		ModelAndView mav = new ModelAndView("listarDependente");
		mav.addObject("dependente", lista);
		return mav;
	}
	
		
		/**REMOVER*/
	@GetMapping("/remov/{id}")
	public ModelAndView removerDependente(@PathVariable("id") long id) {
		Dependente aRemover = depRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		depRepo.delete(aRemover);
		return new ModelAndView("redirect:/listarDependente");
	}

	@PostMapping("/cadastrarDependente")
	public String adicionarDependente(Dependente d) {
		this.depRepo.save(d);
		return "redirect:/listarClientes";
	}
	@GetMapping("/editt/{id}")
	public ModelAndView formEditarDependente(@PathVariable("id") long id) {
		Dependente dependente = depRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
		ModelAndView modelAndView = new ModelAndView("editarDependente");
		modelAndView.addObject(dependente);
		return modelAndView;
	}
	@PostMapping("/editt/{id}")
	public ModelAndView editarDependente(@PathVariable("id") long id, Dependente d) {
		this.depRepo.save(d);
		return new ModelAndView("redirect:/listarDependente");
	}


}