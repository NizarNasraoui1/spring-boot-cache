package com.javatpoint.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.javatpoint.model.Customer;
@RestController
public class CustomerController 
{
	@GetMapping("/cache/with-key/{id}")
	@Cacheable(value="customerInfo",key = "#id")
	public String cacheWithKey(@PathVariable("id")int id,@PathVariable("key")int key) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/cache-with-condition/{id}")
	@Cacheable(value="customerInfo",condition = "#id>20")
	public String cache(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}



	@GetMapping("/update-cache/{id}")
	@CachePut(value="customerInfo",key = "#id")
	public String updateCache(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/clean-cache")
	@CacheEvict(value="customerInfo", allEntries=true)
	public String cleanCache(){
		return "cache cleaned";
	}
}
