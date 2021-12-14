package com.ppx.mhl.domain;

import java.sql.Date;

/**
 * @author ppx
 * @version 1.8
 * 这是一个javabean对bill的响应
 *id INT PRIMARY KEY AUTO_INCREMENT,
 *billId VARCHAR(50) NOT NULL DEFAULT '',#账单编号
 *menuId INT NOT NULL DEFAULT 0,#菜品编号
 *nums INT NOT NULL DEFAULT 0, #份数
 *money DOUBLE NOT NULL DEFAULT 0,#金额
 *diningTableId INT NOT NULL DEFAULT 0,#餐桌编号
 *billDate DATETIME NOT NULL,#订单日期
 *state VARCHAR(50) NOT NULL DEFAULT '' #状态-未结账-已结账-挂单
 */

public class Bill {
    private int id;
    private String billId;
    private int nums;
    private double money;
    private int diningTableId;
    private int menuId;
    private Date billDate;
    private String state;

    public Bill() {
    }

    public Bill(int id, String billId, int nums, double money, int diningTableId, Date billDate, String state,int menuId) {
        this.id = id;
        this.billId = billId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
        this.menuId=menuId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(int diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t" + nums +
                "\t\t" + money +
                "\t\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state ;
    }
}

