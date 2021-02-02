package net.javaguides.springboot.model;

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
	
    @Column(name = "bTitle")
	private String title;

    @Column(name = "bContent")
	private String content;
	
    @Column(name = "bDate")
	private Date date;
	
    @Column(name = "bRecommend")
	private int recommend;
	
	@Column(name = "uCode")
	private Long uCode;
	
}
