package com.tts.Companies.CompaniesRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.Companies.model.Companies;


public interface CompaniesRepository extends CrudRepository<Companies, Long> {

	public List<Companies> findAll();

	public Companies findCompaniesById(Long id);

	public List<Companies> findAllCompaniesByhasEnvironmentProgram(Boolean eco);

	
	
}
