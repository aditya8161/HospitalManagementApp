package com.jpademo.HospitalManagement.service;

import com.jpademo.HospitalManagement.entity.Doctor;
import com.jpademo.HospitalManagement.repository.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService
{
    private final DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }

    public Doctor getDoctorByEmail(String email){
        return doctorRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Doctor not found :"+email));
    }

    public Doctor getDoctorById(Long doctorId){
        return doctorRepo.findById(doctorId).orElseThrow(()->new RuntimeException("Doctor Not Dound :"+doctorId));
    }

}
