package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService service;

    @GetMapping
    public Page<Account> getAllAccounts(Pageable pageable) {
        return service.getAllAccounts(pageable);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable(name = "id") short id) {
        return service.getAccountByID(id);
    }

    @GetMapping("/name/{username}")
    public Account getAccountByUsername(@PathVariable(name = "username") String username) {
        return service.getAccountByUsername(username);
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody Account account) {
        service.createAccount(new Account(account.getEmail(), account.getUsername(), account.getFirstName(), account.getLastName(), account.getDepartment(), account.getPosition(), account.getSalary()));
    }

    @PutMapping("/updateAD/{id}/{departmentId}")
    public void updateAccountDepartment(@PathVariable(name = "id") short id, @PathVariable(name = "departmentId") short departmentId) {
        service.updateAccountDepartment(id, departmentId);
    }

    @PutMapping("/updateAP/{id}/{positionId}")
    public void updateAccountPosition(@PathVariable(name = "id") short id, @PathVariable(name = "positionId") short positionId) {
        service.updateAccountPosition(id, positionId);
    }

    @PutMapping("/updateAS/{id}/{salaryId}")
    public void updateAccountSalary(@PathVariable(name = "id") short id, @PathVariable(name = "salaryId") short salaryId) {
        service.updateAccountSalary(id, salaryId);
    }

    @PutMapping("/updateAll")
    public void updateAccount(@RequestBody Account account) {
        service.updateAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable(name = "id") short id) {
        service.deleteAccount(id);
    }

    @GetMapping("/checkIdExist/{id}")
    public boolean isDepartmentExistsByID(@PathVariable(name = "id") short id) {
        return service.isAccountExistsByID(id);
    }

    @GetMapping("/checkNameExist/{username}")
    public boolean isAccountExistsByUsername(@PathVariable(name = "username") String username) {
        return service.isAccountExistsByUsername(username);
    }
}
