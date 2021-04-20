package controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Cadeia;
import repository.CadeiaRepo;

@Controller
public class CadeiaController {
	@Autowired
	private CadeiaRepo cadeiaRepo;

	@RequestMapping("/salvarCadeia")
	public ModelAndView criarView() {
		ModelAndView mv = new ModelAndView("/cadeia/Criarcadeia");
		return mv;
	}

	@PostMapping("/salvarCadeia")
	public ModelAndView criar(Cadeia cadeia) {
		ModelAndView mv = new ModelAndView("/cadeia/Criarcadeia");
		Cadeia cadeiaExistente = cadeiaRepo.findByNome(cadeia.getNome());
		if (cadeiaExistente == null) {
			cadeiaRepo.save(cadeia);
		}
		String mensagem = "erro, a cadeira ja existe";
		mv.addObject("mensagem", mensagem);
		return mv;

	}

	@RequestMapping("listaCadeias")
	public ModelAndView Listar() {
		ModelAndView mv = new ModelAndView("/cadeia/listaCadeias");
		List<Cadeia> cadeia = cadeiaRepo.findAll();
		return mv.addObject("cadeia", cadeia);
	}

	@RequestMapping("/actualizarCadeia")
	public ModelAndView ViewActualizar() {
		ModelAndView mv = new ModelAndView("/cadeia/Criarcadeia");
		return mv;

	}

	@PutMapping("/actualizarCadeia/{id}")
	public ModelAndView ctualizar(@PathVariable long id, Cadeia cadeiaNova) {
		ModelAndView mv = new ModelAndView("/cadeia/Criarcadeia");

		Cadeia cadeiaAntiga = cadeiaRepo.findById(id);
		BeanUtils.copyProperties(cadeiaNova, cadeiaAntiga, "id");
		cadeiaRepo.save(cadeiaAntiga);

		return mv;

	}

	public ModelAndView pesquisaView(String nome) {
		ModelAndView mv = new ModelAndView("/cadeia/listaCadeias");
		Cadeia cadeiaExistente = cadeiaRepo.findByNome(nome);
		if (cadeiaExistente != null) {
			return mv.addObject("cadeiaExistente", cadeiaExistente);
		}
		String mensagem = "erro, a cadeira ja existe";
		mv.addObject("mensagem", mensagem);
		return mv;

	}

}
