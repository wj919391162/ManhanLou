package com.ppx.mhl.service;

import com.ppx.mhl.dao.BillDAO;
import com.ppx.mhl.dao.MultiTableDAO;
import com.ppx.mhl.domain.Bill;
import com.ppx.mhl.domain.MultiBean;

import java.util.List;
import java.util.UUID;

/**
 * @author ppx
 * @version 1.8
 * 完成对表的各种操作--通过调用表的DAO对象来完成---业务层
 */

public class BillService {
    private BillDAO billDAO =new BillDAO();
    private MenuService menuService=new MenuService();
    private DiningService diningService=new DiningService();
    private MultiTableDAO multiTableDAO=new MultiTableDAO();

    public boolean orderMenuList(int menuId, int nums,int diningTableId){
        //生成一个账单号
        String billID = UUID.randomUUID().toString();
        int price = menuService.getMenuById(menuId).getPrice() * nums ;
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未支付')",
                billID, menuId, nums, price, diningTableId);
        if ( update<= 0){
            return false;
        }
        // 更新餐桌状态
        return diningService.updateDiningTableState(diningTableId,"就餐中");
    }

    public List<Bill> getBillList(){
        return billDAO.queryMulti("select * from bill",Bill.class);
    }
    //多表查询
    public List<MultiBean> getBillList2(){
        return multiTableDAO.queryMulti("select bill.*,NAME from bill,menu where bill.menuId = menu.id",MultiBean.class);
    }

    public Bill getPriceById(int id){
        return billDAO.querySingle("select * from bill where diningTableId = ?",Bill.class,id);
    }

    public boolean updatePay (int tableId,String state){
        int update = billDAO.update("update bill set state = ? where diningTableId = ?", state, tableId);
        return update>0;
    }
}
