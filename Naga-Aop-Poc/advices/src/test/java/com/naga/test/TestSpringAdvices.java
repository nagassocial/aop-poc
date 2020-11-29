package com.naga.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.naga.config.AppConfig;
import com.naga.exception.MinimumAmountException;
import com.naga.model.Account;
import com.naga.service.TransferService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TestSpringAdvices {
	
	@Autowired
	private TransferService transferService;
	
	@Test
	public void transferAmount() throws MinimumAmountException{
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		transferService.transfer(source, dest, 100);
	}
	
	//any thing below 10 is an error case, please change the value from 10 or above to have successful cases like 100 above
	@Test
	public void transferAmountException() throws MinimumAmountException{
		Account source = new Account(123456,"Account1");
		Account dest = new Account(987654,"Account2");
		transferService.transfer(source, dest, 9);
	}
}
