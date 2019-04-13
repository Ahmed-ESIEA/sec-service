package com.adeo.web;

import com.adeo.entities.AppUser;
import com.adeo.service.AccountService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm) {
        return accountService.saveUser(userForm.getUserName(), userForm.getPassword(), userForm.getConfirmedPassword());
    }
}

@Data
class UserForm {
    private String userName;
    private String password;
    private String confirmedPassword;


}
