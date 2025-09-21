package com.jpademo.HospitalManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String gender;
    private LocalDate birthDate;

    @OneToOne(mappedBy = "patient",cascade = {CascadeType.MERGE,CascadeType.REMOVE},orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Insurance insurance;


    @OneToMany(mappedBy = "patient",cascade ={CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Appointment> appointments=new ArrayList<>();

    //stackover flow come means circular operation running
    // Patient fetch Appointment & Appointment Fetch Patient
    //you need to exclude from Tostring or json




}
