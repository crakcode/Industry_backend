package com.industry.service.checkcompany;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.industry.entity.CheckCompany;
import com.industry.entity.Community;
import com.industry.entity.Company;


@Repository
public interface CheckCompanyRepository extends JpaRepository<CheckCompany, Long>{

//	CheckCompany findByUCodeAndCompanyId(Long ucode, String name);

	@Query(value="select * from tb_checkcompany c where c.u_code=:ucode and c.company_id=:companyId",nativeQuery=true)
	List<CheckCompany> findByCompanyIdAndUcode(@Param("ucode") Long ucode,@Param("companyId") Long companyId);
	
	@Query(value="select * from tb_checkcompany c where c.company_id=:companyId",nativeQuery=true)
	List<CheckCompany> findByCompanyId(@Param("companyId") Long companyId);
	

}
