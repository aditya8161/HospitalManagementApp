package com.jpademo.HospitalManagement.repository;

import com.jpademo.HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findByName(String name);
    Optional<Doctor> findByEmail(String email);
}
