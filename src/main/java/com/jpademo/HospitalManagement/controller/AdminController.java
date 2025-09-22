package com.jpademo.HospitalManagement.controller;

import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PatientService patientService;

    //get all PAtient

    @GetMapping("/patients")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatients();
    }


}
