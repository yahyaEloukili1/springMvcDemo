package org.ensas.springMvcDemo.web;

import java.util.List;

import org.ensas.springMvcDemo.dao.PatientRepository;
import org.ensas.springMvcDemo.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	@GetMapping(path = "/index")
	public String index() {
		return "index";
	}
	@GetMapping(path = "/patients")
	public String listPatients(Model model,@RequestParam(name ="page",defaultValue = "0") int page,@RequestParam(name ="size",defaultValue = "5") int size,
			@RequestParam(name ="keyword",defaultValue = "") String mc) {
		Page<Patient> pagePatients = patientRepository.findByNameContains(mc,PageRequest.of(page, size));
		model.addAttribute("patients",pagePatients.getContent());
		model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("keyword",mc);
		model.addAttribute("size", size);
		return "listPatients";
		
	}
	@GetMapping(path="/deletePatient")
	public String deletePatient(Long id,int page,int size,String keyword) {
		patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}
}
