package com.industry.rest.user;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.industry.common.ResourceNotFoundException;
import com.industry.dao.community.CommunityService;
import com.industry.dao.user.UserService;
import com.industry.dto.community.CommunityTO;
import com.industry.dto.user.UserTO;
import com.industry.entity.Community;
import com.industry.entity.User;
import com.industry.service.user.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/user")
public class UserCtrl {
	
	@Autowired
    private UserService userServ;

	@Autowired
	private UserRepository userReps;
	
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userServ.getAllUsers();
    }

    @PostMapping("")
    public void findModelMapper(@RequestBody UserTO userTO) {
    	ModelMapper modelMapper = new ModelMapper();
    	User user = userReps.findById(userTO.getUcode())
    			.orElseGet(User::new);
    	modelMapper.map(userTO,user);
    	userReps.save(user);
    }

    // 기존의 Entity 저장 로직
//    @PostMapping("")
//    public void createSystemCode(@RequestBody User user) {
//    	userServ.createUser(user);
//    }

    @PostMapping("/{ucode}")
    public ResponseEntity<User> getCommunityById(@PathVariable Long ucode){
    	System.out.println(ucode);
    	return userServ.getUserById(ucode);
    }


    @PostMapping("/login")
    public boolean login(User user){
    	System.out.println(user.getEmail());
    	return userServ.login(user);
    }
    
    // writer로 
    
    
//    @PutMapping("/{categoryId}/{key}")
//    public void updateSystemCode(@PathVariable String categoryId, @PathVariable String key, @RequestBody CodeTO codeTO) {
//        domainServ.save(codeTO);
//    }
//    @DeleteMapping("/{categoryId}/{key}")
//    public void deleteSystemCode(@PathVariable String categoryId, @PathVariable String key) {
//        domainServ.delete(new SystemCode.Key(categoryId, key));
//    }
}
