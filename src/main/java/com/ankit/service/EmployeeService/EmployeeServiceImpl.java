package com.ankit.service.EmployeeService;

import com.ankit.dao.Employee.EmployeeDAO;
import com.ankit.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ankit07 on 9/9/16.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService  {

//    @Autowired
    private EmployeeDAO employeeDao;

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee entity = employeeDao.findById(employee.getId());
        if(entity != null){
            entity.setName(employee.getName());
            entity.setJoiningDate(employee.getJoiningDate());
            entity.setSalary(employee.getSalary());
            entity.setSsn(employee.getSsn());
        }
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        employeeDao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public Employee findEmployeeBySsn(String ssn) {
        return employeeDao.findEmployeeBySsn(ssn);
    }

    @Override
    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }
}
