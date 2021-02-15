package com.industry.rest.crawling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.industry.entity.Company;
import com.industry.service.company.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/crawling")
public class CrawllingCtrl {
	
	@Autowired
	private CompanyRepository companyResp;
	
	//HashMap<Integer,String> map = new HashMap<>();//new에서 타입 파라미터 생략가능
	//map.put(1,"사과");
	
	
    @GetMapping("")
    public List<String> getComapnyListandRank() {
		
		List<String> map=new ArrayList();
		try {
			Document doc = Jsoup.connect("https://www.teamblind.com/kr/company/%EA%B3%B5%EB%AC%B4%EC%9B%90/").get();
			Elements divs =doc.select(".star");
			System.out.println(divs.get(0));
			return map;
		}catch(Exception e){
			System.out.println("Error!");
			return map;
		}
    }
    
    
    //되도록이면 쓰지말것
    
    @GetMapping("/list")
    public HashMap<String,String> getCompanyRank() {
    	List<String> map=new ArrayList();
    	HashMap<String,String> hash = new HashMap<>();//new에서 타입 파라미터 생략가능

    	for(int i=0;i<companyResp.findAll().size();i++) {
            String company=companyResp.findAll().get(i).getCompanyName();
            String replace = company.replaceAll("\\(주\\)", " ").replaceAll("\\(유\\)", " ");
            map.add(replace);
    	}
    	System.out.println(map);
    	System.out.println(map.size());
    	System.out.println(map.get(1));
    	for(int a=0;a<map.size();a++) {
    		try{
    			Document doc = Jsoup.connect("https://www.teamblind.com/kr/company/"+map.get(a)).get();
        		Elements divs =doc.select(".star");
        		hash.put(map.get(a),divs.get(0).text());
        		System.out.println(divs.get(0).text());
    		}
    		catch(Exception e) {
    			hash.put(map.get(a),"없음");
    		}
    	}
    	return hash;

    }
//		try {
//			for(int a=0;a<map.size();a++) {
//				Document doc = Jsoup.connect("https://www.teamblind.com/kr/company/"+map.get(a)).get();
//				Elements divs =doc.select(".star");
//				hash.put(map.get(a),divs.get(0).text());
//				//System.out.println(divs.get(0));
//				return hash;
//			}
//		}catch(Exception e){
//			System.out.println("Error!");
//			return hash;
//			}
//		return hash;


    
    @GetMapping("/companys")
    public List<String> ComapyReturnName() {
    	List<String> map=new ArrayList();
    	for(int i=0;i<companyResp.findAll().size();i++) {
            String company=companyResp.findAll().get(i).getCompanyName();
            map.add(company);
    	}
        return map;
    }
}
