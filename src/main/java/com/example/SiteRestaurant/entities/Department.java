package com.example.SiteRestaurant.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "dep_name")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,targetEntity = Employee.class)
    private Set<Employee> employeeSet;

}
