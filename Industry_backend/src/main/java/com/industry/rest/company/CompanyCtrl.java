package com.industry.rest.company;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.dao.community.CommunityService;
import com.industry.dao.company.CompanyService;
import com.industry.dao.user.UserService;
import com.industry.dto.community.CommunityTO;
import com.industry.dto.company.CompanyTO;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/company")
public class CompanyCtrl {
	
	@Autowired
    private CompanyService companyServ;

    @GetMapping("/list")
    public List<Company> getAllUsers() {
        return companyServ.getAllCompany();
    }

    @GetMapping("/{location}")
    public List<Company> getByCompanylocation(@PathVariable String location) {
        return companyServ.getByCompanylocation(location);
    }
    
    @GetMapping("/name/{name}")
    public List<Company> getByCompanyName(@PathVariable String name) {
        return companyServ.getByCompanyName(name);
    }

    @GetMapping("/search")
    public List<Company> getByDyanamicKeyword(@RequestBody CompanyTO companyTO) {
    	companyTO.getLocation();
    	System.out.println(companyTO.getName());
        return companyServ.getByDyanamicKeyword(companyTO);
    }

//    @PostMapping("")
//    public void createSystemCode(@RequestBody User user) {
//    	userServ.createUser(user);
//    }
//
//    @PostMapping("/{ucode}")
//    public ResponseEntity<User> getCommunityById(@PathVariable Long ucode){
//    	System.out.println(ucode);
//    	return userServ.getUserById(ucode);
//    }
//
//
//    @PostMapping("/login")
//    public boolean login(User user){
//    	System.out.println(user.getEmail());
//    	return userServ.login(user);
//    }
    
//    @PutMapping("/{categoryId}/{key}")
//    public void updateSystemCode(@PathVariable String categoryId, @PathVariable String key, @RequestBody CodeTO codeTO) {
//        domainServ.save(codeTO);
//    }
//    @DeleteMapping("/{categoryId}/{key}")
//    public void deleteSystemCode(@PathVariable String categoryId, @PathVariable String key) {
//        domainServ.delete(new SystemCode.Key(categoryId, key));
//    }
}
