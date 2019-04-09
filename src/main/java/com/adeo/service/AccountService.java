package com.adeo.service;

import com.adeo.entities.AppRole;
import com.adeo.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username,String password,String confirmed);
    public AppRole saveRole(AppRole appRole);
    public AppUser loadUserByUsername(String userName);
    public void addRoleToUser(String userName,String roleName);
}
