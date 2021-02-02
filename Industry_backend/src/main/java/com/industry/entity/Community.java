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
@Table(name = "tb_community")
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bCode")
	private long bcode;
	
	@Column
	private String title;

	@Column
	private String content;
	
	@Column
	private Date date;
	
	@Column
	private int recommend;
	
	@Column(name = "uCode")
	private Long uCode;
	
}
