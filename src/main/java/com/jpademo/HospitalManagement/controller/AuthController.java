package com.jpademo.HospitalManagement.controller;

import com.jpademo.HospitalManagement.entity.AppUser;
import com.jpademo.HospitalManagement.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<AppUser> signUpUser(@RequestBody AppUser appUser){

        AppUser appUser1 = appUserService.addAppUser(appUser);
        if(appUser1 != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(appUser1);
        }

        return ResponseEntity.badRequest().build();
    }
}
