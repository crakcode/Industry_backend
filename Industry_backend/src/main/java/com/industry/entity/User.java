package com.industry.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uCode")
	private long ucode;
	
	public long getUcode() {
		return ucode;
	}

	public void setUcode(long ucode) {
		this.ucode = ucode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCretedAt() {
		return cretedAt;
	}

	public void setCretedAt(Date cretedAt) {
		this.cretedAt = cretedAt;
	}

	@Column
	private String email;

	@Column
	private String name;

	@Column
	private String phone;
	
	public List<CheckCompany> getCheckcompanys() {
		return checkcompanys;
	}

	public void setCheckcompanys(List<CheckCompany> checkcompanys) {
		this.checkcompanys = checkcompanys;
	}

	@Column
	private String password;
	
	@Column
	private Date cretedAt;
	
	@OneToMany(mappedBy="user")
	private List<CheckCompany> checkcompanys;
	
}
