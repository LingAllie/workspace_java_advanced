package com.vti.service;

import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {

    public Page<Account> getAllAccounts(Pageable pageable);
    public Account getAccountByID(short id);
    public Account getAccountByUsername(String username);
    public void createAccount(Account account);
    public void updateAccountDepartment(short id, short departmentId);
    public void updateAccountPosition(short id, short positionId);
    public void updateAccountSalary(short id, short salaryId);
    public void updateAccount(Account account);
    public void deleteAccount(short id);
    public boolean isAccountExistsByID(short id);
    public boolean isAccountExistsByUsername(String username);
}
