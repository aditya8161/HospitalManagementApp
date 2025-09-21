package com.jpademo.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "insurance")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;
    private String provider;

    @CreationTimestamp
    private LocalDate createdDate;

    private LocalDate validUntil;

    @OneToOne
    @JoinColumn(name = "patient_id") //by default take this name:patient_id
    private Patient patient;




}
