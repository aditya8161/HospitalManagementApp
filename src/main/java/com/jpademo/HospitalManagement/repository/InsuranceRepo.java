package com.jpademo.HospitalManagement.repository;

import com.jpademo.HospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance,Long> {

}
