package com.ppx.mhl.domain;

/**
 * @author ppx
 * @version 1.8
 * 这是一个javabean对employee的响应
 */

public class Employee {
    private Integer id;
    private String empId;
    private String name;
    private String password;
    private String job;

    public Employee() {
    }

    public Employee(Integer id, String empId, String name, String password, String job) {
        this.id = id;
        this.empId = empId;
        this.name = name;
        this.password = password;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
