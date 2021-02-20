package com.industry.rest.crawling;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;
import com.industry.common.CommonUtil;
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
		System.out.println("hell");
		try {
			Document doc = Jsoup.connect("www.jobplanet.co.kr/search?query=배달의민족").get();
			Elements divs =doc.select(".rate_ty02");
			System.out.println(divs.size());
			System.out.println(divs.get(0));
			return map;
		}catch(Exception e){
			System.out.println("Error!");
			return map;
		}
    }

    
    
    //되도록이면 쓰지말것
    //4~5 Diamond
    //3~4 platinum
    //2~3 gold
    //1~2 Silver
    //0= unrank

    @GetMapping("/list")
    public HashMap<String,String> getCompanyRank() {
    	List<String> map=new ArrayList();
    	//검색 전처리 과정 필요한 데이터만 남기기 
    	HashMap<String,String> hash = new HashMap<>();//new에서 타입 파라미터 생략가능
    	for(int i=0;i<companyResp.findAll().size();i++) {
            String company=companyResp.findAll().get(i).getCompanyName();
            String replace = company.replaceAll("\\(주\\)", " ").replaceAll("\\(유\\)", " ");
            map.add(replace);
    	}
    	for(int a=0;a<10;a++) {
    		try{
    			Document doc = Jsoup.connect("https://www.teamblind.com/kr/company/"+map.get(a)).get();
        		Elements divs =doc.select(".star");
        		
//        		hash.put(map.get(a),divs.get(0).text());
        		//score는 doc.star에 해당하는 값들을 가져와서 비교하면됨 
//        		Long score=Long.parseLong(divs.get(0).text()); 
//        		System.out.println(divs.get(0).text());
//        		System.out.println(score);
//        		String key="";
//        		if(score>4) {
//        			key="Diamond";
//        		}else if(score >3) {
//        			key="Platinum";
//        		}else if(score>2) {
//        			key="Gold";
//        		}else if(score>1) {
//        			key="Silver";
//        		}else {
//        			key="UnRank";
//        		}
        		System.out.println(divs.get(0).text());
//    			hash.put(map.get(a),key);
    		}
    		catch(Exception e) {
//    			hash.put(map.get(a),"UnRank");
        		System.out.println("Exception");

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


    @PostMapping("/desc/{companyName}")
    public String getCompanyInfo(@PathVariable String companyName) {
		Document doc;
		try {
            String replace = companyName.replaceAll("\\(주\\)", " ").replaceAll("\\(유\\)", " ");
			doc = Jsoup.connect("https://www.teamblind.com/kr/company/"+replace).get();
    		Elements divs =doc.select(".desc p");
    		String text=divs.toString();
    		String tagRemove = text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
    		System.out.println(tagRemove);
    		return tagRemove;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception");
			return "exception";
		}

    }
    
    @GetMapping("/companys")
    public List<String> ComapyReturnName() {
    	List<String> map=new ArrayList();
    	for(int i=0;i<companyResp.findAll().size();i++) {
            String company=companyResp.findAll().get(i).getCompanyName();
            map.add(company);
    	}
        return map;
    }
    
    @GetMapping("/latitude")
    public Map<String,String> getLatitude(){
    	Map<String,String> dic=new HashMap<String,String>();
//    	companyResp.findAll().get(1).getCompanyLocation();
//    	Float[] a=CommonUtil.geoCodings(companyResp.findAll().get(1).getCompanyLocation());
//    	dic.put(companyResp.findAll().get(1).getCompanyName(), a.toString());
    	String location = "경기도 성남시 분당구 삼평동";
    	Float[] coords = CommonUtil.geoCodings(location);
    	System.out.println(location + ": " + coords[0] + ", " + coords[1]);

    	return dic;
    }
    
    
}
