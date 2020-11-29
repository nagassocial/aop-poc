package com.naga.service;

import com.naga.model.Account;

public interface TransferService {
	
	boolean transfer(Account source, Account dest, int amount);
	
	double checkBalance(Account a);
}
