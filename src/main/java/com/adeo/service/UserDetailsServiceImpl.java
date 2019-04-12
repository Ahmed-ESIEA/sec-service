package com.adeo.service;

import com.adeo.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    @Autowired
    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(s);
        if (appUser == null) throw new UsernameNotFoundException("Invalid User");
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        appUser.getRoles().forEach(appRole -> grantedAuthorities.add(new SimpleGrantedAuthority(appRole.getRoleName())));
        return new User(appUser.getUserName(), appUser.getPassword(), grantedAuthorities);
    }
}
