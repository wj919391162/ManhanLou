package com.ppx.mhl.service;

import com.ppx.mhl.dao.DiningDAO;
import com.ppx.mhl.domain.DiningTable;
import org.junit.Test;

import java.util.List;

/**
 * @author ppx
 * @version 1.8
 * 完成对表的各种操作--通过调用表的DAO对象来完成---业务层
 */

public class DiningService {

    private DiningDAO diningDAO = new DiningDAO();


    public List<DiningTable> list(){
        return diningDAO.queryMulti("select id,state from dinningTable", DiningTable.class);
    }

    public DiningTable getDiningTableById(int id){
        return diningDAO.querySingle("select * from dinningTable where id=?",DiningTable.class,id);
    }

    public boolean orderDiningTable(int id,String orderName,String orderTel){
        int update = diningDAO.update("update dinningTable set state='已被预定',orderName=?,orderTel=? where id=?",orderName,orderTel,id);
        return update>0;
    }

    //更新餐桌状态的方法
    public boolean updateDiningTableState(int id,String state){
        int update = diningDAO.update("update dinningTable set state = ? where id = ?", state, id);
        return update > 0;
    }
}
