package ru.dasha.CurrencyCbrService.cbrclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfig {
	
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.BASIC;
	}
}
