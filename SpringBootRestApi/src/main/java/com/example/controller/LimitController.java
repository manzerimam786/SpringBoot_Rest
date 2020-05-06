package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.LimitConfiguration;

@RestController
@RequestMapping("/limits")
public class LimitController {

	@Autowired
	LimitConfiguration limitConfiguration;
	@RequestMapping(value="/limit", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public void getValuesFromPropertiesFile()
	{
		//System.out.println(new LimitConfiguration("10","1000"));
		System.out.println("Minimum value="+limitConfiguration.getMin()+" ,max="+limitConfiguration.getMax()); 
	}
}
