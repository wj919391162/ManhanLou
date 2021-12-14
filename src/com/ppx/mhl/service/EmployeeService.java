package com.ppx.mhl.service;

import com.ppx.mhl.dao.EmployeeDAO;
import com.ppx.mhl.domain.Employee;

/**
 * @author ppx
 * @version 1.8
 * 完成对表的各种操作--通过调用表的DAO对象来完成
 */

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId和pwd返回一个employee对象
    public Employee getEmployeeByIdAndPwd(String empId,String pwd){

        Employee employee =
                employeeDAO.querySingle("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);

        return employee;
    }
}
