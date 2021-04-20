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

import model.Recruso;
import repository.RecrusoRepo;
@Controller
public class RecrusoController {

	@Autowired
	private RecrusoRepo RecrusoRepo;

	@RequestMapping("/salvarRecruso")
	public ModelAndView criarView() {
		ModelAndView mv = new ModelAndView("/Recruso/CriarRecruso");
		return mv;
	}

	@PostMapping("/salvarRecruso")
	public ModelAndView criar(Recruso Recruso) {
		ModelAndView mv = new ModelAndView("/Recruso/CriarRecruso");

		String mensagem = "Suceso, Salvo com sucesso";
		mv.addObject("mensagem", mensagem);
		return mv;

	}

	@RequestMapping("listaRecrusos")
	public ModelAndView Listar() {
		ModelAndView mv = new ModelAndView("/Recruso/listaRecrusos");
		List<Recruso> Recruso = RecrusoRepo.findAll();
		return mv.addObject("Recruso", Recruso);
	}

	@RequestMapping("/actualizarRecruso")
	public ModelAndView ViewActualizar() {
		ModelAndView mv = new ModelAndView("/Recruso/CriarRecruso");
		return mv;

	}

	@PutMapping("/actualizarRecruso/{id}")
	public ModelAndView atualizar(@PathVariable long id, Recruso RecrusoNova) {
		ModelAndView mv = new ModelAndView("/Recruso/CriarRecruso");

		Recruso RecrusoAntiga = RecrusoRepo.findById(id);
		BeanUtils.copyProperties(RecrusoNova, RecrusoAntiga, "id");
		RecrusoRepo.save(RecrusoAntiga);

		return mv;

	}

	public ModelAndView pesquisaView(String nome) {
		ModelAndView mv = new ModelAndView("/Recruso/listaRecrusos");
		Recruso RecrusoExistente = RecrusoRepo.findByNome(nome);
		if (RecrusoExistente != null) {
			return mv.addObject("RecrusoExistente", RecrusoExistente);
		}
		String mensagem = "erro, a cadeira ja existe";
		mv.addObject("mensagem", mensagem);
		return mv;

	}


}
