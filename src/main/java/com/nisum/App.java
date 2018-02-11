package com.nisum;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * Hello world!
 *
 */
@SpringBootApplication
//@ComponentScan("com.nisum")
@EnableCaching
public class App 
{
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
	/*@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("employeeCache");
		
	}*/
}
