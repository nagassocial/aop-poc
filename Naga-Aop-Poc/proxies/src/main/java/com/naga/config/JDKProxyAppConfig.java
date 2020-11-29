package com.naga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.naga.service.TransferService;
import com.naga.service.Impl.TransferServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class JDKProxyAppConfig {

	@Bean
	@Scope(proxyMode=ScopedProxyMode.INTERFACES)
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
}
