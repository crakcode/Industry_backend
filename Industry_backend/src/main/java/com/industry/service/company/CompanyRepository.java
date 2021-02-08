package com.industry.service.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industry.entity.Community;
import com.industry.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	List<Company> findByCompanyLocationContaining(String location);

	List<Company> findByCompanyNameContaining(String name);
	

}
