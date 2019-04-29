package com.usoft.service;

import com.usoft.dao.DepartmentDao;
import com.usoft.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_29-12:17
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public Department getDepartmentById(Integer id){
        return departmentDao.getDepartmentById(id);
    }

    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }

}
