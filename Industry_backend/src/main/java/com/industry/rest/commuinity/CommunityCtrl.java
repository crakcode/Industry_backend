package com.industry.rest.commuinity;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.dao.community.CommunityService;
import com.industry.dto.community.CommunityTO;
import com.industry.entity.Community;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/community")
public class CommunityCtrl {
	
	@Autowired
    private CommunityService communityservice;

    @GetMapping("/list")
    public List<Community> getAllCommunity() {
        return communityservice.getAllCommunity();
    }

    @PostMapping("")
    public void createSystemCode(@RequestBody Community Community) {
    	communityservice.createCommunity(Community);
    }

    @GetMapping("/{bcode}")
    public ResponseEntity<Community> getCommunityById(@PathVariable Long bcode){
    	return communityservice.getCommunityById(bcode);
    }
    
    
//    @PutMapping("/{categoryId}/{key}")
//    public void updateSystemCode(@PathVariable String categoryId, @PathVariable String key, @RequestBody CodeTO codeTO) {
//        domainServ.save(codeTO);
//    }
//    @DeleteMapping("/{categoryId}/{key}")
//    public void deleteSystemCode(@PathVariable String categoryId, @PathVariable String key) {
//        domainServ.delete(new SystemCode.Key(categoryId, key));
//    }
}
