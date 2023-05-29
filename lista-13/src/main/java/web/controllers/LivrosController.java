package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.model.Livros;
import web.repository.LivrosRepository;

@Controller
public class LivrosController {
@Autowired
	private LivrosRepository ur;		//crud
//…
//… Métodos de inserção de dados

	@RequestMapping(value="/cadastrarLivros", method=RequestMethod.GET)
	public String form(){
		return "livros/formLivros";
	}
	
	@RequestMapping(value="/cadastrarLivros", method=RequestMethod.POST)
	public String form(Livros livro){
		
		ur.save(livro);
		return "redirect:/cadastrarLivros";
	}
	// …

	// Consulta de dados

	@RequestMapping("/listarLivros")
		public ModelAndView listaUsuarios(){
			
			ModelAndView mv = new ModelAndView("livros/listarLivros");
			
			Iterable<Livros> livros = ur.findAll();
			//ur.findById(null)
			
			mv.addObject("livros",livros);
			return mv;
		}
	}
