package com.adeo.service;

import com.adeo.entities.AppRole;
import com.adeo.entities.AppUser;

public interface AccountService {
    AppUser saveUser(String username, String password, String confirmed);

    AppRole saveRole(AppRole appRole);

    AppUser loadUserByUsername(String userName);

    void addRoleToUser(String userName, String roleName);
}
