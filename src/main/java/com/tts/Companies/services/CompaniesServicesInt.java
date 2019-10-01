package com.tts.Companies.services;

import java.util.List;

import com.tts.Companies.model.Companies;

public interface CompaniesServicesInt {

	List<Companies> getAll();

	Companies getByCompaniesId(Long id);

	String postCompany(Companies newCompanies);

	String deleteAllCompanies();

	String updateCompanies(Long id, Companies changes);

	List<Companies> getEcoFriendly(Boolean eco);

}
