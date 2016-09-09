package com.ankit.controller.Employee;

import com.ankit.domain.Income;
import com.ankit.model.Employee;
import com.ankit.service.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ankit07 on 9/9/16.
 */
@RestController
@Configuration
@ComponentScan(basePackages = "com.ankit.service.EmployeeService")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value ="/employee/",method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployee(ModelMap model){
        List<Employee> employeeList = employeeService.findAllEmployee();
        if( employeeList.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
    }
}
