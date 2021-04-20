package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import model.Cadeia;
import repository.CadeiaRepo;

@Controller
public class CadeiaController {
	@Autowired private CadeiaRepo cadeiaRepo;
	
	
	
	public ModelAndView criar(Cadeia cadeia) {
		 ModelAndView mv = new ModelAndView("");
	Cadeia cadeiaExistente = cadeiaRepo.findByNome(cadeia.getNome());
		if(cadeiaExistente == null) {
			cadeiaRepo.save(cadeia);
		}
		String mensagem = "erro, a cadeira ja existe";
		mv.addObject(mensagem, "mensagem");
		return mv;
		 
		
		
	}

}
