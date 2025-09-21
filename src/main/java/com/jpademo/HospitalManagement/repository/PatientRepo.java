package com.jpademo.HospitalManagement.repository;

import com.jpademo.HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long>
{
    @Query("SELECT p FROM Patient p JOIN FETCH p.appointments WHERE p.id = ?1")
    Optional<Patient> findByIdWithAppointments(Long id);

    @Query("SELECT p FROM Patient p JOIN FETCH p.appointments a JOIN FETCH a.doctor WHERE p.id = ?1")
    Optional<Patient> findByIdWithAppointmentsAndDoctors(Long id);


    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments LEFT JOIN FETCH p.insurance")
    List<Patient> findAllPatientWithAppointmentAndInsurance();

}
