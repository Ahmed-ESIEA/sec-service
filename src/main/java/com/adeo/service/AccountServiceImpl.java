package com.adeo.service;

import com.adeo.dao.AppRoleRepository;
import com.adeo.dao.AppUserRepository;
import com.adeo.entities.AppRole;
import com.adeo.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String confirmed) {
        AppUser appUser = appUserRepository.findByUserName(username);
        if (appUser != null) throw new RuntimeException("User already exist");
        if (!password.equals(confirmed)) throw new RuntimeException("Please Confirm your Password");
        AppUser user = new AppUser();
        user.setActived(true);
        user.setUserName(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(user);
        addRoleToUser(username, "USER");
        return user;
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String userName) {
        return null;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

    }
}
