package com.naga.service;

import com.naga.exception.MinimumAmountException;
import com.naga.model.Account;

public interface TransferService {
	
	boolean transfer(Account source, Account dest, int amount) throws MinimumAmountException;
}
