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
	@GetMapping("/cache")
	@Cacheable(value="info")
	public String simpleCache() throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/cache/with-key/{id}")
	@Cacheable(value="info",key = "#id")
	public String cacheWithKey(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/cache-with-condition/{id}")
	@Cacheable(value="info",condition = "#id>20")
	public String cacheWithCondition(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}



	@GetMapping("/update-cache-with-key/{id}")
	@CachePut(value="info",key = "#id")
	public String updateCacheWithKey(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/update-simple-cache")
	@CachePut(value="info")
	public String updateSimpleCache() throws InterruptedException {
		Thread.sleep(3000);
		return "response";
	}

	@GetMapping("/clean-cache")
	@CacheEvict(value="info", allEntries=true)
	public String cleanCache(){
		return "cache cleaned";
	}
}
