package com.naga.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naga.config.PerformanceInterceptorAppConfig;
import com.naga.model.Account;
import com.naga.service.TransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PerformanceInterceptorAppConfig.class)
public class TestPerformenceInterceptor {


	@Autowired
	private TransferService transferService = null;
	
	@Test
	public void testMethodProfiling(){
		
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		this.transferService.transfer(source, dest, 100);
	}
}
