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
	@GetMapping("/cache/{id}")
	//defines a cache for method's return value
	@Cacheable(value="customerInfo",condition = "#id>20")
	public List cache(@PathVariable("id")int id) throws InterruptedException {
		Thread.sleep(3000);
		List detail=Arrays.asList(new Customer(5126890,"Charlie Puth","Current A/c", 450000.00),
								  new Customer(7620015,"Andrew Flintoff","Saving A/c", 210089.00)
								 );
	return detail;
	}

	@GetMapping("/cache/{id}/{key}")
	//when we change id the cache is still available, but when we change key the cache will update
	@Cacheable(value="customerInfo",key = "#key")
	public List cacheWithKey(@PathVariable("id")int id,@PathVariable("key")int key) throws InterruptedException {
		//adding customer detail in the List
		Thread.sleep(3000);
		List detail=Arrays.asList(new Customer(5126890,"Charlie Puth","Current A/c", 450000.00),
				new Customer(7620015,"Andrew Flintoff","Saving A/c", 210089.00)
		);
		return detail;
	}

	@GetMapping("/updatecache/{id}")
	@CachePut(value="customerinfo")
	public List updateCache(@PathVariable("id")int id) throws InterruptedException {
		System.out.println("customer information from cache");
		//adding customer detail in the List
		Thread.sleep(3000);
		List detail=Arrays.asList(new Customer(5126890,"Charlie Puth","Current A/c", 450000.00),
				new Customer(7620015,"Andrew Flintoff","Saving A/c", 210089.00)
		);
		return detail;
	}

	@GetMapping("/cleancache")
	@CacheEvict(value="customerInfo", allEntries=true)
	public String cleanCache(){
		return "cache cleaned";
	}
}
