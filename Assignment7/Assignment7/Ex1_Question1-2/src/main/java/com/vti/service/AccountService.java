package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Salary;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.repository.ISalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ISalaryRepository iSalaryRepository;

    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Autowired
    private IPositionRepository iPositionRepository;



    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Account getAccountByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public Account getAccountByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void createAccount(Account account) {
        repository.save(account);
    }

    @Override
    public void updateAccountDepartment(short id, short departmentId) {
        Account updateAccount = getAccountByID(id);
        Department acc_dep = iDepartmentRepository.findById((int) id).get();
        updateAccount.setDepartment(acc_dep);
        repository.save(updateAccount);
    }

    @Override
    public void updateAccountPosition(short id, short positionId) {
        Account updateAccount = getAccountByID(id);
        Position acc_pos = iPositionRepository.findById((int) id).get();
        updateAccount.setPosition(acc_pos);
        repository.save(updateAccount);
    }

    @Override
    public void updateAccountSalary(short id, short salaryId) {
        Account updateAccount = getAccountByID(id);
        Salary acc_sal = iSalaryRepository.findById((int) id).get();
        updateAccount.setSalary(acc_sal);
        repository.save(updateAccount);
    }

    @Override
    public void updateAccount(Account account) {
        repository.save(account);
    }

    @Override
    public void deleteAccount(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isAccountExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isAccountExistsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
