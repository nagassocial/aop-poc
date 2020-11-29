package com.naga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.naga.advisor.CustomPerformanceMonitorAdvisor;
import com.naga.aspect.CustomPerformanceMonitorInterceptor;
import com.naga.aspect.TransferMonitoringAspect;
import com.naga.service.TransferService;
import com.naga.service.impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class CustomPerformanceInterceptorAppConfig {
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl();
	}

	@Bean
	public CustomPerformanceMonitorInterceptor customPerformanceMonitorInterceptor() {
		return new CustomPerformanceMonitorInterceptor(true);
	}

	@Bean
	public TransferMonitoringAspect transferAspect() {
		return new TransferMonitoringAspect();
	}

	@Bean
	public CustomPerformanceMonitorAdvisor customPerformanceMonitorAdvisor() {
		return new CustomPerformanceMonitorAdvisor(customPerformanceMonitorInterceptor());
	}
}
