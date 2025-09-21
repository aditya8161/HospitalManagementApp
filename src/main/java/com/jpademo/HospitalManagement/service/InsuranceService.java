package com.jpademo.HospitalManagement.service;

import com.jpademo.HospitalManagement.entity.Insurance;
import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.exception.ResourceNotFoundException;
import com.jpademo.HospitalManagement.repository.InsuranceRepo;
import com.jpademo.HospitalManagement.repository.PatientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService
{
    @Autowired
    private InsuranceRepo insuranceRepo;

    @Autowired
    private PatientRepo patientRepo;

    //add Insurance to the patient
    @Transactional
   public Insurance addNewInsuranceToPatient(Long patientId,Insurance insurance){
       Patient exsiting_patient = patientRepo.findById(patientId)
               .orElseThrow(()-> new RuntimeException("Patient Not Found :"+patientId));

       if(insurance != null){
           insurance.setPatient(exsiting_patient);
       }
         insurance.setPatient(exsiting_patient); //owing
         exsiting_patient.setInsurance(insurance); //bi-directional mapping

        Insurance savedInsurance = insuranceRepo.save(insurance);

        return savedInsurance;
   }

   //detach service from Patient
    @Transactional
    public Patient detachInsuranceFromPatient(long patientId)
    {
       Patient patient = patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Resource Not Found..."+patientId));

       patient.setInsurance(null);

       return patient;
    }



}
