package com.jpademo.HospitalManagement.test1;

import com.jpademo.HospitalManagement.entity.Appointment;
import com.jpademo.HospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest
{
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void addNewAppointment(){
        Appointment appointment = Appointment.builder()
                .reason("Nee Injury check")
                .status("Not Complete")
                .appointmentTime(LocalDateTime.of(2025,9,10,9,30))
                .build();

        Appointment savedAppointment = appointmentService.addNewAppointment(appointment, 4L, 5L);
//        System.out.println(savedAppointment.getAppointmentTime()+"|"+savedAppointment.getReason());
        System.out.println(savedAppointment.getDoctor().getName());  //explicitliy get in transactional then run

        //reAssign Doctor service check
        Appointment appointment1 = appointmentService.reAssignAppointmentDoctor(3L, 1L);
        System.out.println(appointment1.getId()+"|"+appointment1.getStatus());
    }

    @Test
    public void detachAppointmentsFromPatient()
    {
        boolean status = appointmentService.detachAppointmentFromPatient(4);
        System.out.println(status);
    }
}
