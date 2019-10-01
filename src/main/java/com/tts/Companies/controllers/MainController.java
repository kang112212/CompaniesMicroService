package com.tts.Companies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.Companies.model.Companies;
import com.tts.Companies.services.CompaniesServicesImpl;

@RestController
public class MainController {
	
	@Autowired
	CompaniesServicesImpl companiesServicesImpl;
	
	@GetMapping("/")
	public String defaultLink() {
		return "Try a different directory. http://localhost:8080/companies or http://localhost:8080/company";
	}
	
	@GetMapping("/companies")
	public List<Companies> mapAll() {
		return companiesServicesImpl.getAll();
	}
	
	@GetMapping("/companies/{id}")
	public Companies mapById(@PathVariable Long id) {
		return companiesServicesImpl.getByCompaniesId(id);
	}

	@GetMapping("/companies/isecofriendly")
	public List<Companies> mapEcoFriendly(@RequestParam Boolean hasEnvironmentProgram){
		return companiesServicesImpl.getEcoFriendly(hasEnvironmentProgram);
	}
	
	@PostMapping("/companies/add")
	public String postIt(Companies newCompanies) {
		return companiesServicesImpl.postCompany(newCompanies);
	}
	
	@PutMapping("/companies/update/{id}")
	public String updateIt(@PathVariable Long id, Companies changes) {
		return companiesServicesImpl.updateCompanies(id, changes);
	}
	
	  
	@DeleteMapping("/companies/delete")
	public String deleteAll() {
		return companiesServicesImpl.deleteAllCompanies();
	}
}
