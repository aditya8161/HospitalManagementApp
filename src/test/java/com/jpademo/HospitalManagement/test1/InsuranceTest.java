package com.jpademo.HospitalManagement.test1;

import com.jpademo.HospitalManagement.entity.Insurance;
import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.service.InsuranceService;
import com.jpademo.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
public class InsuranceTest
{
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;

    @Test
    public void addInsuranceToPatient(){

        LocalDate validUntildate = LocalDate.of(2025, Month.OCTOBER, 30);

        LocalDate currentDate = LocalDate.now();



        Insurance insurance = Insurance.builder()
                .policyNumber("MH66735sdfr")
                .provider("Maharashtra Health")
                .validUntil(validUntildate)
                .createdDate(currentDate)
                .build();

        insuranceService.addNewInsuranceToPatient(2L,insurance );
        System.out.println("Add insurance ");

    }

    @Test
    public void detachInsuranceFromPatient(){
        Patient patient = insuranceService.detachInsuranceFromPatient(4);

        System.out.println(patient);
    }
}
