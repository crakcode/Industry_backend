package com.industry.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyId")
	private long companyId;
	
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @param companyLocation the companyLocation to set
	 */
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	/**
	 * @param companyTel the companyTel to set
	 */
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	@Column
	private String companyName;
	
	@Column
	private String companyLocation;
	
	@Column
	private String companyTel;
	
}
