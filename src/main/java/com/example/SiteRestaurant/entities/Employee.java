package com.example.SiteRestaurant.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "birth_date")
    private String birthDate;

    @Column(name= "hire_date")
    private String hireDate;

    @ManyToOne
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Department department;
}
