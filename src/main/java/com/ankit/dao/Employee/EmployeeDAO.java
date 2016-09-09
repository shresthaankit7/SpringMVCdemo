package com.ankit.dao.Employee;

import com.ankit.model.Employee;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by ankit07 on 9/7/16.
 */
public interface EmployeeDAO {
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);
}
