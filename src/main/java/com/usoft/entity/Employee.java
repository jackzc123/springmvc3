package com.usoft.entity;

import org.springframework.stereotype.Component;

/**
 * @author zc
 * @create 2019-04_29-12:13
 */
@Component
public class Employee {

    private Integer id;
    private String username;
    private String password;
    private Integer sex;
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String username, String password, Integer sex, Department department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", department=" + department +
                '}';
    }
}
