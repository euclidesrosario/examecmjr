package controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Cadeia;
import repository.CadeiaRepo;

@Controller
public class CadeiaController {
	@Autowired private CadeiaRepo cadeiaRepo;
	
	
	public ModelAndView criarView () {
		ModelAndView mv = new ModelAndView("/cadeia/Criarcadeia");
		return mv;
	}
	
	@RequestMapping("/salvarCadeia")
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
	
	@RequestMapping("/actualizarCadeia")
	public ModelAndView ViewActualizar () {
		 ModelAndView mv = new ModelAndView("");
		return mv;
		
	}
	
	@PutMapping("/actualizarCadeia/{id}")
	public ModelAndView ctualizar (@PathVariable long id, Cadeia cadeiaNova) {
		 ModelAndView mv = new ModelAndView("");
		
		 Cadeia cadeiaAntiga = cadeiaRepo.findById(id);
		 BeanUtils.copyProperties(cadeiaNova, cadeiaAntiga);
		 
		 cadeiaRepo.save(cadeiaAntiga);
		 
		return mv;
		
	}
	

}
