package com.naga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.naga.aspect.TransferServiceAspect;
import com.naga.service.TransferService;
import com.naga.service.Impl.TransferServiceImpl;


@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
	
	@Bean
	public TransferServiceAspect transferServiceAspect(){
		return new TransferServiceAspect();
	}
}
