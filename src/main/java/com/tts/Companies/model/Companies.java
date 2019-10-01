package com.tts.Companies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Companies {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String industryType;
	private Boolean hasEnvironmentProgram;
	private String ownershipStructure;
	private Double glassdoorRating;
	private Integer oneToTenRating;
	
	
	public Companies() {};
	
	public Companies(String name, String industryType, Boolean hasEnvironmentProgram, String ownershipStructure,
			Double glassdoorRating, Integer oneToTenRating) {
		super();
		this.name = name;
		this.industryType = industryType;
		this.hasEnvironmentProgram = hasEnvironmentProgram;
		this.ownershipStructure = ownershipStructure;
		this.glassdoorRating = glassdoorRating;
		this.oneToTenRating = oneToTenRating;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public Boolean getHasEnvironmentProgram() {
		return hasEnvironmentProgram;
	}

	public void setHasEnvironmentProgram(Boolean hasEnvironmentProgram) {
		this.hasEnvironmentProgram = hasEnvironmentProgram;
	}

	public String getOwnershipStructure() {
		return ownershipStructure;
	}

	public void setOwnershipStructure(String ownershipStructure) {
		this.ownershipStructure = ownershipStructure;
	}

	public Double getGlassdoorRating() {
		return glassdoorRating;
	}

	public void setGlassdoorRating(Double glassdoorRating) {
		this.glassdoorRating = glassdoorRating;
	}

	public Integer getOneToTenRating() {
		return oneToTenRating;
	}

	public void setOneToTenRating(Integer oneToTenRating) {
		this.oneToTenRating = oneToTenRating;
	}

	@Override
	public String toString() {
		return "Companies [id=" + id + ", name=" + name + ", industryType=" + industryType + ", hasEnvironmentProgram="
				+ hasEnvironmentProgram + ", ownershipStructure=" + ownershipStructure + ", glassdoorRating="
				+ glassdoorRating + ", oneToTenRating=" + oneToTenRating + "]";
	}
	
	
	
}

