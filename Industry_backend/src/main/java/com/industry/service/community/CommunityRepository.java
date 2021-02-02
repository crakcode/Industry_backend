package com.industry.service.community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.industry.entity.Community;


@Repository
public interface CommunityRepository extends JpaRepository<Community, Long>{

}
