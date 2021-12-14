package com.ppx.mhl.service;

import com.ppx.mhl.dao.MenuDAO;
import com.ppx.mhl.domain.Menu;

import java.util.List;

/**
 * @author ppx
 * @version 1.8
 * 完成对表的各种操作--通过调用表的DAO对象来完成
 */

public class MenuService {

    private MenuDAO menuDAO =new MenuDAO();

    public List<Menu> getMenuList(){
        return menuDAO.queryMulti("select * from menu",Menu.class);
    }

    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id = ?",Menu.class,id);
    }
}
