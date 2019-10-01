package com.tts.Companies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.Companies.CompaniesRepository.CompaniesRepository;
import com.tts.Companies.model.Companies;

@Service
public class CompaniesServicesImpl implements CompaniesServicesInt {
	
	@Autowired
	CompaniesRepository companiesRepository;
	
	@Override
	public List<Companies> getAll() {	
		return companiesRepository.findAll();
	}

	@Override
	public Companies getByCompaniesId(Long id) {
		return companiesRepository.findCompaniesById(id);
	}
	
	@Override
	public List<Companies> getEcoFriendly(Boolean eco) {
		return companiesRepository.findAllCompaniesByhasEnvironmentProgram(eco);
	}

	@Override
	public String postCompany(Companies newCompanies) {
		companiesRepository.save(newCompanies);
		return "You submitted " + newCompanies;
	}

	@Override
	public String deleteAllCompanies() {
		companiesRepository.deleteAll();
		return "All Gone. Proof: " + companiesRepository.findAll();
		
	}

	
	@Override
	public String updateCompanies(Long id, Companies changes) {
		Companies updatingCompany = companiesRepository.findCompaniesById(id);
		String name = changes.getName();
		String industryType = changes.getIndustryType();
		Boolean hasEnvironmentProgram = changes.getHasEnvironmentProgram();
		String ownershipStructure = changes.getOwnershipStructure();
		Double glassdoorRating = changes.getGlassdoorRating();
		Integer oneToTenRating = changes.getOneToTenRating();
		
		updatingCompany.setName(name);
		updatingCompany.setIndustryType(industryType);
		updatingCompany.setHasEnvironmentProgram(hasEnvironmentProgram);
		updatingCompany.setOwnershipStructure(ownershipStructure);
		updatingCompany.setGlassdoorRating(glassdoorRating);
		updatingCompany.setOneToTenRating(oneToTenRating);
		
		companiesRepository.save(updatingCompany);
		
		return "You updated Company to " + updatingCompany;
	}

	
	
	
}
