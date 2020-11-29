package com.naga.config;

import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.naga.advisor.PerformanceMonitorAdvisor;
import com.naga.aspect.TransferMonitoringAspect;
import com.naga.service.TransferService;
import com.naga.service.impl.TransferServiceImpl;

@EnableAspectJAutoProxy
@Configuration
public class PerformanceInterceptorAppConfig {
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl();
	}

	@Bean
	public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
		return new PerformanceMonitorInterceptor(true);
	}
	
	@Bean
	public TransferMonitoringAspect transferAspect() {
		return new TransferMonitoringAspect();
	}

	@Bean
	public PerformanceMonitorAdvisor performanceMonitorAdvisor() {
		return new PerformanceMonitorAdvisor(performanceMonitorInterceptor());
	}
}
