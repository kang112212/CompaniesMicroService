package com.tts.Companies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return "Try a different directory. https://reactcompanies.herokuapp.com/companies";
	}

	@CrossOrigin
	@GetMapping("/companies")
	public List<Companies> mapAll() {
		return companiesServicesImpl.getAll();
	}

	@CrossOrigin
	@GetMapping("/companies/{id}")
	public Companies mapById(@PathVariable Long id) {
		return companiesServicesImpl.getByCompaniesId(id);
	}

	@CrossOrigin
	@GetMapping("/companies/isecofriendly")
	public List<Companies> mapEcoFriendly(@RequestParam Boolean hasEnvironmentProgram){
		return companiesServicesImpl.getEcoFriendly(hasEnvironmentProgram);
	}

	@CrossOrigin
	@GetMapping("/companies/isabove8")
	public List<Companies> mapAbove8(@RequestParam Integer oneToTenRating){
		return companiesServicesImpl.getAbove8(oneToTenRating);
	}

	@CrossOrigin
	@PostMapping("/company")
	public String postIt(@RequestBody Companies newCompanies) {
		return companiesServicesImpl.postCompany(newCompanies);
	}

	@CrossOrigin
	@PutMapping("/companies/update/{id}")
	public String updateIt(@PathVariable Long id, @RequestBody Companies changes) {
		return companiesServicesImpl.updateCompanies(id, changes);
	}

	@CrossOrigin
	@DeleteMapping("/companies/delete")
	public String deleteAll() {
		return companiesServicesImpl.deleteAllCompanies();
	}

	@CrossOrigin
	@DeleteMapping("/company/{id}")
	public String deleteCompany(@PathVariable Long id) {
		return companiesServicesImpl.deleteCompaniesById(id);
	}
}
