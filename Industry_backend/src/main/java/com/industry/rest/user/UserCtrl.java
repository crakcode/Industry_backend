package com.industry.rest.user;

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
import com.industry.entity.CheckCompany;
import com.industry.entity.Community;
import com.industry.entity.Company;
import com.industry.entity.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserCtrl {
	
	@Autowired
    private UserService userServ;
	
	@Autowired
    private CompanyService companyServ;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userServ.getAllUsers();
    }
    
    @GetMapping("/company/{ucode}")
    public  List<Company> createCompanyByUcode(@PathVariable Long ucode) {
        return companyServ.createCompanyByUcode(ucode);
    }

    @PostMapping("")
    public void createSystemCode(@RequestBody User user) {
    	userServ.createUser(user);
    }

    @PostMapping("/{ucode}")
    public ResponseEntity<User> getCommunityById(@PathVariable Long ucode){
    	System.out.println(ucode);
    	return userServ.getUserById(ucode);
    }

    @PostMapping("/{ucode}/{name}")
    public void crateMyCompany(@PathVariable Long ucode,@PathVariable String name){
    	companyServ.crateMyCompany(ucode,name);
    }

    @PostMapping("/login")
    public boolean login(User user){
    	System.out.println(user.getEmail());
    	return userServ.login(user);
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
