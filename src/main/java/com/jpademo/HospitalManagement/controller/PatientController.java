package com.jpademo.HospitalManagement.controller;

import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    //like name or birthdate
    @PatchMapping("/update")
    public Patient updatePatient(@RequestParam long id, @RequestBody Patient updatedPatient){  //id -> patientId

        Patient patient = patientService.updatePatientById(id, updatedPatient);

        return patient;
    }

    

    @DeleteMapping
    public ResponseEntity<?> deletePatientById(@RequestParam long patientId){
        boolean status = patientService.deletePatientById(patientId);

        if (status){
            return ResponseEntity.ok("Patient Deleted Successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Patient Not Delete, Due to some error.!");
    }
}
