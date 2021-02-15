package com.industry.rest.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/file")
public class file {
	
	@PostMapping("/upload")
	public List<String> upload(@RequestPart List<MultipartFile> files) throws Exception {
		List<String> list = new ArrayList<>();
		for (MultipartFile file : files) {
			String originalfileName = file.getOriginalFilename();
			File dest = new File("C:/Image/" + originalfileName);
			file.transferTo(dest);
			// TODO
		}
		return list;

	}
}
