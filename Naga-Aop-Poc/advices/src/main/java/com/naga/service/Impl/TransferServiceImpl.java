package com.naga.service.Impl;

import org.apache.log4j.Logger;

import com.naga.exception.MinimumAmountException;
import com.naga.model.Account;
import com.naga.service.TransferService;

public class TransferServiceImpl implements TransferService {
	private static final Logger LOGGER = Logger.getLogger(TransferServiceImpl.class);

	@Override
	public boolean transfer(Account source, Account dest, int amount) throws MinimumAmountException {
		// transfer amount from source account to dest account
		LOGGER.info("Tranfering " + amount + " from " + source.getAccountName() + " to " + dest.getAccountName());
		if (amount < 10) {
			throw new MinimumAmountException("Amount greater than 10 required to transfer online");
		}
		return true;
	}

}
