package com.vti.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFilterForm;

public interface IAccountService {

	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilterForm filterForm);

	public Account getAccountByID(int id);
}
