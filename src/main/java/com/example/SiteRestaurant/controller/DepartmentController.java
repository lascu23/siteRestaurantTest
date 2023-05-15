package com.example.SiteRestaurant.controller;

import com.example.SiteRestaurant.entities.Department;
import com.example.SiteRestaurant.entities.Employee;
import com.example.SiteRestaurant.repository.DepartmentRepository;
import com.example.SiteRestaurant.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/departments")
    public String displayDepartmentsPage(Model model){
        List<Department> departmentList = departmentRepository.findAll();

        model.addAttribute("departments", departmentList);
        return "departments.html";
    }
}
