package com.webscraping.stockdata.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webscraping.stockdata.entity.CompnyListBean;

@RestController
public class CompanyListController {



	@RequestMapping(method = RequestMethod.GET, value ="/GetstockList")
	public List<CompnyListBean> getCompanyList(){
		System.out.println("calling GetstockList using feign client");
		List<CompnyListBean> response=null;
		response.stream().
				map(c -> c.getIndustry()).
		distinct().forEach(p -> System.out.println("industries:"+p+" Number:"+ p.indexOf(p=p+1)));

		return response;
		

	}
}
