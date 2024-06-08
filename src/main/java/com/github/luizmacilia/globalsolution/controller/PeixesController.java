package com.github.luizmacilia.globalsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.luizmacilia.globalsolution.model.Peixe;
import com.github.luizmacilia.globalsolution.repository.PeixeRepository;

@Controller
@RequestMapping("/peixes")
public class PeixesController {

	@Autowired
	private PeixeRepository peixeRepository;
	
	@GetMapping()
	public String list(Model model) {
		List<Peixe> peixes = peixeRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("peixes", peixes);
		return"peixe/lista.html";
	}
	
	@GetMapping("add")
	public String Create(Model model) {
		model.addAttribute("peixe", new Peixe());
		return "peixe/form";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute Peixe peixe) {
	
		
		peixeRepository.save(peixe);
		return "redirect:/peixes";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Peixe peixe = peixeRepository.findById(id).orElse(new Peixe());
		model.addAttribute("peixe", peixe);
		return "peixe/form";
	}
	
}
