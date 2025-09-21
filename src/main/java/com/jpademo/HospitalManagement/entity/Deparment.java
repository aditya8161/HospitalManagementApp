package com.jpademo.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deparment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deparment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate createdAt;

    //deparment -> headDoctor (1 to 1)
    @OneToOne
    @JoinColumn(name = "headDoctor_id")
    private Doctor headDoctor;

    //deparments <--> doctors (Many to Many)
    @ManyToMany
    @JoinTable(     //custom table defination write
            name = "my_dpt_doctors",
            joinColumns = @JoinColumn(name = "dpt_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors = new ArrayList<>();



}
