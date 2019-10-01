package com.tts.Companies;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.tts.Companies.CompaniesRepository.CompaniesRepository;
import com.tts.Companies.model.Companies;


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.MOCK,
		classes = CompaniesApplication.class
		)
	
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integrationtest.properties")
public class CompaniesIntegrationTests {
	
	@Autowired
	CompaniesRepository companiesRepository;
	
	@Autowired
	MockMvc mvc;
	
	Companies coreyCo;
	
	@Before
	public void setUp() {
		coreyCo = new Companies("coreyCo", "Awesome", true, "privateSmall", 5.0, 10);
		companiesRepository.save(coreyCo);
	}
	@After
	public void tearDown() {
		companiesRepository.deleteAll();
	}
	
	@Test
	public void givenIdProduceCompany() throws Exception {
	Long companyId = coreyCo.getId();
	mvc.perform( get("/companies/" + companyId).contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk())
	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	.andExpect(jsonPath("$.name", is("coreyCo")));
	}

	
	
}
