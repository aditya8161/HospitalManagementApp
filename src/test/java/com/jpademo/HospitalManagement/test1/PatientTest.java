package com.jpademo.HospitalManagement.test1;

import com.jpademo.HospitalManagement.entity.Appointment;
import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest
{
    @Autowired
    private PatientService patientService;

    @Test
    public void addPatient(){
        Patient p1 = Patient.builder()
                .name("Aditya")
                .email("aditya@gmail.com")
                .gender("male")
                .birthDate(LocalDate.of(2003,9,18))
                .build();

        Patient patient = patientService.addPatient(p1);
        System.out.println(patient);
    }

    @Test
    public void getMyAppointments(){
        List<Appointment> myAppointments = patientService.getMyAppointments(2L);

//        myAppointments.forEach(System.out::println);
        for(Appointment appointment : myAppointments){
//            System.out.println(appointment.getReason()+"|"+appointment.getAppointmentTime()+"|"+appointment.getStatus()+"|"+appointment.getDoctor().getName());
            System.out.println(appointment.getReason()+"|"+appointment.getAppointmentTime()+"|"+appointment.getStatus());
        }
    }

    @Test
    public void getAllPatient(){
        List<Patient> allPatients = patientService.getAllPatients();
        allPatients.stream().forEach(System.out::println);
        System.out.println("Complete Print ALl PAtient ");
    }
}
