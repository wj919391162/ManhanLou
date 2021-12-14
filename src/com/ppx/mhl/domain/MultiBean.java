package com.ppx.mhl.domain;

import java.sql.Date;

/**
 * @author ppx
 * @version 1.8
 * 这是一个javabean对多张表的对应
 */

public class MultiBean {
    private int id;
    private String billId;
    private int nums;
    private double money;
    private int diningTableId;
    private int menuId;
    private Date billDate;
    private String state;
    private String NAME;

    public MultiBean() {
    }

    public MultiBean(int id, String billId, int nums, double money, int diningTableId, int menuId, Date billDate, String state, String NAME) {
        this.id = id;
        this.billId = billId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.menuId = menuId;
        this.billDate = billDate;
        this.state = state;
        this.NAME = NAME;
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

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t" + NAME +
                "\t\t" + nums +
                "\t\t" + money +
                "\t\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state ;
    }
}
