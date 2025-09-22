package com.jpademo.HospitalManagement.service;

import com.jpademo.HospitalManagement.entity.AppUser;
import com.jpademo.HospitalManagement.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService
{
    @Autowired
    private AppUserRepository appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //add AppUSer
    public AppUser addAppUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepo.save(appUser);
    }

}
