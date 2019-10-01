package com.tts.Companies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tts.Companies.CompaniesRepository.CompaniesRepository;
import com.tts.Companies.model.Companies;
import com.tts.Companies.services.CompaniesServicesImpl;
import com.tts.Companies.services.CompaniesServicesInt;


@RunWith(SpringRunner.class)
public class CompaniesMethodTests {
	
	@Configuration
	static class ServiceConfig{
		@Bean
		public CompaniesServicesInt configuration() {
			return new CompaniesServicesImpl();
		}
	}
	
	@Autowired
	CompaniesServicesInt companiesService;
	
	@MockBean
	CompaniesRepository companiesRepository;
	
	private static Companies coreCo;
	private static Companies gregCo;
	private static List<Companies> companiesList;
	private static List<Companies> trueList;
	
	@Before
	public void setUp() {
		coreCo = new Companies("coreyCo", "Awesome", true, "privateSmall", 5.0, 10);
		gregCo = new Companies("gregCo", "Sweet", false, "privateLarge", 4.8, 9);
		companiesList = new ArrayList<>();
		
		companiesList.add(coreCo);
		companiesList.add(gregCo);
		
		trueList = new ArrayList<>();
		trueList.add(coreCo);
		
	}
	
	@After
	public void breakDown() {
		companiesRepository.deleteAll();
	}
	
	@Test
	public void givenCompaniesId_returnCompany() {
		Mockito.when(companiesRepository.findCompaniesById(2L)).thenReturn(coreCo);
		Companies found = companiesService.getByCompaniesId(2l);
		assertThat(coreCo).isEqualToComparingFieldByField(found);
	}
	@Test
	public void findAll_returnAllCompanies() {
		Mockito.when(companiesRepository.findAll()).thenReturn(companiesList);
		List<Companies> found = companiesService.getAll();
		assertEquals(companiesList, found);
	}
	
	@Test
	public void findEcoCompanies() {
		Mockito.when(companiesRepository.findAllCompaniesByhasEnvironmentProgram(true)).thenReturn(trueList);
		List<Companies> found = companiesService.getEcoFriendly(true);
		assertEquals(trueList, found);
	}
	
	
}
