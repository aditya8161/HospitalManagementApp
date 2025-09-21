package com.jpademo.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;


    //assocication with Patient
    @ManyToOne
    @JoinColumn(name = "patient_id")
    @ToString.Exclude
    private Patient patient;

    //association with doctor (Appointment is owning entity)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Doctor doctor;

}
