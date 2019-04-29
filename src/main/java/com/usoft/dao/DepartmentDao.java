package com.usoft.dao;

import com.usoft.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc
 * @create 2019-04_29-12:17
 */
@Repository
public class DepartmentDao {

    private static List<Department> list = null;

    static {

        list = new ArrayList<Department>();

        Department department1 = new Department(1,"A_AA");
        Department department2 = new Department(2,"B_BB");
        Department department3 = new Department(3,"C_CC");
        Department department4 = new Department(4,"D_DD");
        Department department5 = new Department(5,"E_EE");
        list.add(department1);
        list.add(department2);
        list.add(department3);
        list.add(department4);
        list.add(department5);
    }

    public Department getDepartmentById(Integer id){

        for(Department d: list){
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public List<Department> getAllDepartments(){
        return list;
    }

}
