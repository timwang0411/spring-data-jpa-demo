package com.example.springdatajpademo.controller;

import com.example.springdatajpademo.entity.Employee;
import com.example.springdatajpademo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    /*
     * listAll
     */
    @RequestMapping(value = "/")
    public List<Employee> listAll() {
        return employeeService.listAll();
    }

    /*
     * insert
     */
    @RequestMapping(value = "/add")
    public RedirectView add() {
        employeeService.add();
        return new RedirectView("/");
    }

    @RequestMapping(value = "/delete")
    public RedirectView deleteLastAdd(@RequestParam(value = "empId", required = true) Integer empId) {
        employeeService.deleteByEmpId(empId);
        return new RedirectView("/");
    }

    @RequestMapping(value = "/update")
    public RedirectView updateLastAdd(@RequestParam(value = "empId", required = true) Integer empId) {
        employeeService.updateByEmpId(empId);
        return new RedirectView("/");
    }
}