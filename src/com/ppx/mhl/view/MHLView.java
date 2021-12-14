package com.ppx.mhl.view;

import com.ppx.mhl.domain.DiningTable;
import com.ppx.mhl.domain.Employee;
import com.ppx.mhl.service.DiningService;
import com.ppx.mhl.service.EmployeeService;
import com.ppx.mhl.utils.Utility;

import javax.swing.*;
import java.util.List;

/**
 * @author ppx
 * @version 1.8
 * 主界面菜单
 */

public class MHLView {

    private boolean loop = true; //控制是否推出循环菜单
    private String key = ""; //接收用户的输入
    private EmployeeService employeeService = new EmployeeService();
    private DiningService diningService = new DiningService();
    private MHLViewUtils mhlViewUtils = new MHLViewUtils();

    //显示主菜单
    public void mainMenu(){

        while (loop) {
            System.out.println("===============皮皮餐馆===============");
            System.out.println("\t\t 1 登录餐厅系统");
            System.out.println("\t\t 2 退出餐厅系统");
            System.out.println("请输入你的选择：");
            key= Utility.readString(1);

            switch (key){
                case "1":
                    System.out.println("请输入员工账户：");
                    String empId = Utility.readString(50);
                    System.out.println("请输入密码");
                    String pwd = Utility.readString(50);

                    //到数据库去判断
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null){
                        System.out.println("============登录成功["+employee.getName()+"]============\n");

                        //显示二级菜单
                        while(loop){
                            mhlViewUtils.listSecondView();
                            key = Utility.readString(1);

                            switch (key){
                                case "1":
                                    mhlViewUtils.listDinningTable();
                                    break;
                                case "2":
                                    mhlViewUtils.reserveDinningTable();
                                    break;
                                case "3":
                                    mhlViewUtils.menuList();
                                    break;
                                case "4":
                                    mhlViewUtils.orderMenu();
                                    break;
                                case "5":
                                    mhlViewUtils.billList();
                                    break;
                                case "6":
                                    mhlViewUtils.checkBill();
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    loop =false;
                                    break;
                                default:
                                    System.out.println("请输入正确的指令");
                            }
                        }
                    }   else {
                        System.out.println("============登录失败============");
                    }
                    break;
                case "2":
                    System.out.println("退出餐厅系统");
                    loop = false;
                    break;
                default:
                    System.out.println("你输入有误请重新输入");
            }
        }
        System.out.println("已退出系统~");
    }
}
