package com.jpademo.HospitalManagement.repository;

import com.jpademo.HospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepo extends JpaRepository<Appointment,Long>
{
}
