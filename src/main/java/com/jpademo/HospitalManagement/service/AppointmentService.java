package com.jpademo.HospitalManagement.service;

import com.jpademo.HospitalManagement.entity.Appointment;
import com.jpademo.HospitalManagement.entity.Doctor;
import com.jpademo.HospitalManagement.entity.Patient;
import com.jpademo.HospitalManagement.exception.ResourceNotFoundException;
import com.jpademo.HospitalManagement.repository.AppointmentRepo;
import com.jpademo.HospitalManagement.repository.DoctorRepo;
import com.jpademo.HospitalManagement.repository.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService
{
      private final AppointmentRepo appointmentRepo;
      private final PatientRepo patientRepo;
      private final DoctorRepo doctorRepo;

      //add new appointment to patient and doctor
    @Transactional
      public Appointment addNewAppointment(Appointment appointment,Long patientId,Long doctorId){
          Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException("Patient Not Found : " + patientId));
          Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor Not Found : " + doctorId));

          if(appointment.getId() != null)throw new IllegalArgumentException("Appointment should not have already in DB");

          //appointment is owning entity then first save appointment side
          appointment.setPatient(patient);
          appointment.setDoctor(doctor);

          appointment.getDoctor();

          patient.getAppointments().add(appointment);//for consistency (bi-directional mapping)

          Appointment savedAppointment = appointmentRepo.save(appointment);

          return savedAppointment;
      }

      @Transactional
      public Appointment reAssignAppointmentDoctor(Long appointmentId,Long newDoctorId){
          Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow();
          Doctor doctor = doctorRepo.findById(newDoctorId).orElseThrow();

          appointment.setDoctor(doctor);

          return appointment;

      }


      @Transactional
      public boolean detachAppointmentFromPatient(long patientId){
          Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new ResourceNotFoundException());

          List<Appointment> appointments = patient.getAppointments();
          appointments.clear();

          return appointments.isEmpty();
      }

}
