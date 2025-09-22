package com.jpademo.HospitalManagement.controller;

import com.jpademo.HospitalManagement.entity.Doctor;
import com.jpademo.HospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController
{
    private final DoctorService doctorService;

    public ResponseEntity<List<Doctor>> getAllDoctrs(){
        List<Doctor> allDoctors = doctorService.getAllDoctors();

        if(!allDoctors.isEmpty()){
            return ResponseEntity.ok(allDoctors);
        }

        return ResponseEntity.noContent().build();
    }


}
