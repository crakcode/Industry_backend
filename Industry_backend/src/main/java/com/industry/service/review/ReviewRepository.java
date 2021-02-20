package com.industry.service.review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.industry.entity.CheckCompany;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

//	List<Review> findByCompanyId(Long companyId);


	@Query(value="select r.review_id,r.review,r.score from tb_review r join tb_company c on r.company_id=c.company_id where r.company_id=:companyId",nativeQuery=true)
	List<Review> findByCompanyId(@Param("companyId") Long companyId);

	
} 
