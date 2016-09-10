package com.ankit.controller.Employee;

import com.ankit.domain.Income;
import com.ankit.domain.Message;
import com.ankit.model.Employee;
import com.ankit.service.EmployeeService.EmployeeService;
import org.apache.log4j.Logger;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by ankit07 on 9/9/16.
 */
@Controller
public class EmployeeController {

    private static final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(value ="/employee/",method = RequestMethod.GET)
    public String listEmployee(ModelMap model){
        List<Employee> employeeList = employeeService.findAllEmployee();
        model.addAttribute("employees",employeeList);
        return "allEmployee";
    }

    @RequestMapping(value = "/newEmployee/",method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model){
        if( result.hasErrors()){
            log.info("***** Error registration of employee *****");
            return "registration";
        }

        if( employeeService.isEmployeeSsnUnique(employee.getId(),employee.getSsn())){
            FieldError ssnError = new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn",new String[]{employee.getSsn()}, Locale.getDefault())) ;
            result.addError(ssnError);
            return "registration";
        }

        employeeService.saveEmployee(employee);

        model.addAttribute("Success","Employee " + employee.getName() + " registered successfully");
        return "success";
    }
}
