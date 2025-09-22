package com.jpademo.HospitalManagement.controller;

import com.jpademo.HospitalManagement.entity.Doctor;
import com.jpademo.HospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class HospitalController
{
    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public List<Doctor> getALlDoctors(){
        return doctorService.getAllDoctors();
    }
}
