package com.usoft.dao;

import com.usoft.entity.Department;
import com.usoft.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc
 * @create 2019-04_29-12:17
 */
@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    private static List<Employee> list = null;

    static{
        list = new ArrayList<Employee>();

        Employee employee1 = new Employee(1,"zc","123456",0,new Department(1,"A_AA"));
        Employee employee2 = new Employee(2,"aa","123456",0,new Department(2,"B_BB"));
        Employee employee3 = new Employee(3,"bb","123456",1,new Department(3,"C_CC"));
        Employee employee4 = new Employee(4,"cc","123456",1,new Department(4,"D_DD"));
        Employee employee5 = new Employee(5,"dd","123456",0,new Department(5,"E_EE"));
        Employee employee6 = new Employee(6,"ee","123456",1,new Department(1,"A_AA"));

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
    }

    public Employee getEmployeeById(Integer id){
        for(Employee e: list) {
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployee(){
        return list;
    }

    public void deleteEmployee(Integer id){
        for(Employee e: list) {
            if(e.getId() == id){
                list.remove(e);
                break;
            }
        }
    }

    public void addEmployee(Employee employee){
        employee.setId(list.get(list.size()-1).getId()+1);
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        list.add(employee);
    }

    public void updateEmployee(Employee employee){
        Employee employee1 = getEmployeeById(employee.getId());
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        list.set(list.indexOf(employee1), employee);
    }

}
