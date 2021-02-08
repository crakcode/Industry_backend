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
@Table(name = "tb_user")
public class User {
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
	
	@Column
	private String password;
	
	@Column
	private Date cretedAt;
	
	
}
