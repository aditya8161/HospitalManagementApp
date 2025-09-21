package com.jpademo.HospitalManagement.service;

import com.jpademo.HospitalManagement.entity.Appointment;
import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.exception.ResourceNotFoundException;
import com.jpademo.HospitalManagement.repository.AppointmentRepo;
import com.jpademo.HospitalManagement.repository.PatientRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;


    public Patient addPatient(Patient patient){
         return patientRepo.save(patient);
    }

    public Patient getPatientById(Long id){
        return patientRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Patient not found...!"));
    }


    public List<Patient> getAllPatients(){

        List<Patient> all = patientRepo.findAllPatientWithAppointmentAndInsurance();

        return  all;
    }


    //it is patch mapping
    public Patient updatePatientById(long patientId,Patient newPatient){
        Patient existingPatient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found...!"));

        if(newPatient.getName() !=null){
            existingPatient.setName(newPatient.getName());
        }
        if(newPatient.getBirthDate() != null){
            existingPatient.setBirthDate(newPatient.getBirthDate());
        }
        if(newPatient.getGender() != null){
            existingPatient.setGender(newPatient.getGender());
        }




        patientRepo.save(existingPatient);

        return existingPatient;
    }

    //delete patient
    public boolean deletePatientById(long patientId){
        Patient existingPatient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found...!"));

        if(existingPatient != null){
            patientRepo.deleteById(patientId);
            System.out.println("Patient Deleted Successfull");
            return true;
        }


        return false;
    }

    @Transactional
    public List<Appointment> getMyAppointments(Long patientId){
//        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient Not Found : " + patientId));


        //work properly get Appointment with Patient
        Patient patient=patientRepo.findByIdWithAppointments(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient Not Found : " + patientId));

        //get Appointment with Doctor
//        Patient patient = patientRepo.findByIdWithAppointmentsAndDoctors(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient Not Found : " + patientId));
        return patient.getAppointments();

    }
}
