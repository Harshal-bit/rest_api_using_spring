package com.harshal.rest.webservices.restfulwebservices.filtering;



import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		
		Somebean somebean = new Somebean("f1","f2","f3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean); 
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1","f2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		mappingJacksonValue.setFilters(filters);
		return  mappingJacksonValue; 
	}
	
	@GetMapping("/filter-list")
	public List<Somebean> getAllBeans() {
		return Arrays.asList(new Somebean("f1","f2","f3"),new Somebean("f4","f5","f6")); 
	}

}
