package com.industry.dao.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.industry.entity.User;
import com.industry.service.user.UserRepository;
import com.industry.springboot.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository userResp;

	
	// get all community
	public List<User> getAllUsers(){
		return userResp.findAll();
	}

	// insert coulmn into coummunity table using post
	public void createUser(User user) {
		userResp.save(user);
	}

	
	// get coulmn from coummunity table using getmapping
	public ResponseEntity<User> getUserById(@PathVariable Long ucode) {
		User user = userResp.findById(ucode)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + ucode));
		return ResponseEntity.ok(user);
	}
	
	
	public boolean login(User user) {
		User user1=userResp.findByEmail(user.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + user));
	
		if (user1.getPassword()==user.getPassword()) {
			return true;
		}
		else {
			return false;
		}
	}

}
