package com.ppx.mhl.domain;

/**
 * @author ppx
 * @version 1.8
 * 这是一个javabean对menu的响应
 */

public class Menu {
    private Integer id;
    private String NAME;
    private String TYPE;
    private int price;

    public Menu() {
    }

    public Menu(Integer id, String NAME, String TYPE, int price) {
        this.id = id;
        this.NAME = NAME;
        this.TYPE = TYPE;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id+"\t\t"+NAME+"\t\t"+TYPE+"\t\t"+price;
    }
}
