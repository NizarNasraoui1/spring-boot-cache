package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
//enabling caching
@EnableCaching
public class SpringBootCacheExampleApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootCacheExampleApplication.class, args);
}
}
