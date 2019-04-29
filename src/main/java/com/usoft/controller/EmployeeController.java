package com.usoft.controller;

import com.usoft.entity.Employee;
import com.usoft.service.DepartmentService;
import com.usoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zc
 * @create 2019-04_29-19:55
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/empList", method = RequestMethod.GET)
    public String getEmpList(Map<String, Object> map){
        map.put("empList", employeeService.getAllEmployee());
        return "empList";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/empList";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String toEmpAdd(Map<String, Object> map){
        map.put("departments", departmentService.getAllDepartments());
        Employee employee = new Employee();
        employee.setSex(0);
        map.put("employee", employee);
        return "empAdd";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String empAdd(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/empList";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("employee", employeeService.getEmployeeById(id));
        map.put("departments", departmentService.getAllDepartments());
        return "empAdd";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,
                            Map<String, Object> map){
        if (id != null) {
            map.put("employee", employeeService.getEmployeeById(id));
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String empUpdate(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/empList";
    }

}
