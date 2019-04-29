package com.usoft.service;

import com.usoft.dao.EmployeeDao;
import com.usoft.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_29-12:17
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployeeById(Integer id){
       return employeeDao.getEmployeeById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

    public void deleteEmployee(Integer id){
       employeeDao.deleteEmployee(id);
    }

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee){
       employeeDao.updateEmployee(employee);
    }

}
