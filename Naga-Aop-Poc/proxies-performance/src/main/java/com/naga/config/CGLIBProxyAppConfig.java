package com.naga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.naga.service.TransferService;
import com.naga.service.Impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class CGLIBProxyAppConfig {

	@Bean
	@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
	public TransferService transferService(){
		return new TransferServiceImpl();
	}
}
