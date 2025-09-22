package com.jpademo.HospitalManagement.entity;

import com.jpademo.HospitalManagement.entity.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest
{
    private String username;
    private String password;
    private UserRoles userRoles;

}
