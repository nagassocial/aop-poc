package com.naga.service.Impl;

import com.naga.model.Account;
import com.naga.service.TransferService;

public class TransferServiceImpl implements TransferService {

	@Override
	public boolean transfer(Account source, Account dest, int amount) {
		// transfer amount from source account to dest account
		return true;
	}
}
