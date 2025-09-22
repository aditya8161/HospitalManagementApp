package com.jpademo.HospitalManagement.repository;

import com.jpademo.HospitalManagement.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long>
{
    Optional<AppUser> findByUsername(String username);
}
