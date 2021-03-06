package com.nagap.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.naga.config.CGLIBProxyAppConfig;
import com.naga.config.JDKProxyAppConfig;
import com.naga.config.ProxyFactoryBeanConfig;
import com.naga.model.Account;
import com.naga.service.TransferService;

public class TestSpringProxy {

	private static final Logger LOGGER = Logger.getLogger(TestSpringProxy.class);

	@Test
	public void testCGLIBProxy() {
		AnnotationConfigApplicationContext applicationContext = null;
		try {
			//create proxy using CGLIB Proxy
			applicationContext = new AnnotationConfigApplicationContext(CGLIBProxyAppConfig.class);
			TransferService transferService = applicationContext.getBean(TransferService.class);
			LOGGER.info(transferService.getClass().getName());
		} finally {
			applicationContext.close();
		}
	}
	
	@Test
	public void testJDKProxy(){
		AnnotationConfigApplicationContext applicationContext = null;
		try {
			//create proxy using JDK Proxy
			applicationContext = new AnnotationConfigApplicationContext(JDKProxyAppConfig.class);
			TransferService transferService = applicationContext.getBean(TransferService.class);
			LOGGER.info(transferService.getClass().getName());
		} finally {
			applicationContext.close();
		}
	}
	
	@Test
	public void testProxyFactoryBean(){
		AnnotationConfigApplicationContext applicationContext = null;
		try {
			//create proxy using ProxyFactoryBean
			applicationContext = new AnnotationConfigApplicationContext(ProxyFactoryBeanConfig.class);
			TransferService transferService = (TransferService)applicationContext.getBean("transferService");
			LOGGER.info(transferService.getClass().getName());
			
			Account a = new Account(123456, "Account1");
			Account b = new Account(987654, "Account2");
			transferService.transfer(a, b, 100);
		} finally {
			applicationContext.close();
		}

	}
}
