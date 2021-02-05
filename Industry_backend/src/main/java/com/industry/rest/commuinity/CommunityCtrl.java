package com.industry.rest.commuinity;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.industry.dao.community.CommunityService;
import com.industry.entity.Community;

@RequestMapping("/api/v1/community")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class CommunityCtrl {
    private final CommunityService cservice;

//    @GetMapping("/list")
//    public Page<CodeTO> getSystemCodeList(ParamsTO params) {
//        return domainServ.getPage(params);
//    }

    @PostMapping("")
    public void createSystemCode(@RequestBody Community Community) {
    	cservice.save(Community);
    }

//    @PutMapping("/{categoryId}/{key}")
//    public void updateSystemCode(@PathVariable String categoryId, @PathVariable String key, @RequestBody CodeTO codeTO) {
//        domainServ.save(codeTO);
//    }
//
//    @DeleteMapping("/{categoryId}/{key}")
//    public void deleteSystemCode(@PathVariable String categoryId, @PathVariable String key) {
//        domainServ.delete(new SystemCode.Key(categoryId, key));
//    }
}
