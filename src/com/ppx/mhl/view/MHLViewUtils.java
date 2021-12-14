package com.ppx.mhl.view;

import com.ppx.mhl.dao.BillDAO;
import com.ppx.mhl.domain.Bill;
import com.ppx.mhl.domain.DiningTable;
import com.ppx.mhl.domain.Menu;
import com.ppx.mhl.domain.MultiBean;
import com.ppx.mhl.service.BillService;
import com.ppx.mhl.service.DiningService;
import com.ppx.mhl.service.MenuService;
import com.ppx.mhl.utils.Utility;
import org.junit.Test;

import java.util.List;

/**
 * @author ppx
 * @version 1.8
 * 主界面菜单封装显示
 */

public class MHLViewUtils {

    private DiningService diningService = new DiningService();
    private MenuService menuService =new MenuService();
    private BillService billService =new BillService();

    public void listSecondView(){
        System.out.println("============餐厅系统二级菜单============");
        System.out.println("\t\t 1 显示餐桌的状态");
        System.out.println("\t\t 2 预定餐桌");
        System.out.println("\t\t 3 显示所有菜品");
        System.out.println("\t\t 4 点餐服务");
        System.out.println("\t\t 5 查看账单");
        System.out.println("\t\t 6 结账");
        System.out.println("\t\t 9 退出系统");
    }

    //Menu1
    public void listDinningTable(){
        System.out.println("=====显示餐桌的状态=====");
        List<DiningTable> list = diningService.list();
        System.out.println("\n餐桌编号\t餐桌状态");
        for (DiningTable diningTable:list){
            System.out.println(diningTable);
        }
        System.out.println("===显示完成,按0返回主菜单===");
        if(Utility.readString(1).equals("0")){
            return;
        }
    }

    //Menu2
    public void reserveDinningTable(){
        System.out.println("=====预定餐桌=====");
        System.out.println("选择要预定的餐桌编号（0退出）：");
        int orderId = Utility.readInt();

        if (orderId == 0 ) {
            System.out.println("=====取消预定餐桌=====");
            return;
        }
        char key = Utility.readConfirmSelection();
        if ( key == 'Y') {
            DiningTable diningTableById = diningService.getDiningTableById(orderId);
            if ( diningTableById == null ){
                System.out.println("=====预定餐桌不存在=====");
                return;
            }
            if ("空闲".equals(diningTableById.getState())){
                System.out.printf("预定人名字:");
                String orderName = Utility.readString(50);
                System.out.printf("预定人电话:");
                String orderTel = Utility.readString(50);
                if ( diningService.orderDiningTable(orderId, orderName, orderTel) == true ){
                    System.out.println("=====预定成功=====");
                }
            } else {
                System.out.println("=====该餐桌已被预定=====");
                return;
            }
        } else {
            System.out.println("=====取消预定餐桌=====");
            return;
        }
    }

    //Menu3
    public void menuList(){
        System.out.println("========菜单========");
        System.out.println("菜品编号\t菜品名\t类别\t价格");
        List<Menu> menuList = menuService.getMenuList();
        for (Menu menu: menuList){
            System.out.println(menu);
        }
        System.out.println("===显示完成,按0返回主菜单===");
        if(Utility.readString(1).equals("0")){
            return;
        }
    }

    //Menu4
    public void orderMenu(){
        System.out.println("=======点餐服务=======");
        System.out.println("选择要点餐的餐桌编号（0退出）：");
        int orderChose1 = Utility.readInt();
        if (orderChose1 == 0 ) {
            System.out.println("=====取消点餐=====");
            return;
        }
        System.out.println("选择要点餐的菜品编号（0退出）：");
        int orderChose2 = Utility.readInt();
        if (orderChose2 == 0 ) {
            System.out.println("=====取消点餐=====");
            return;
        }
        System.out.println("选择要点餐的菜品数量（0退出）：");
        int orderChose3 = Utility.readInt();
        if (orderChose3 == 0 ) {
            System.out.println("=====取消点餐=====");
            return;
        }
        char key = Utility.readConfirmSelection();
        if ( key == 'Y') {
            boolean b = billService.orderMenuList(orderChose2, orderChose3, orderChose1);
            if ( b== true ){
                System.out.println("=====点餐成功=====");
            }
        }
    }
    @Test
    //Menu5
    public void billList(){
        System.out.println("编号   菜品号\t     菜名\t    数量\t\t金额\t\t\t桌号\t\t\t日期\t\t\t状态");
        List<MultiBean> billList2 = billService.getBillList2();
        for (MultiBean multiBean:billList2){
            System.out.println(multiBean);
        }
        System.out.println("===显示完成,按0返回主菜单===");
        if(Utility.readString(1).equals("0")){
            return;
        }
    }

    //Menu6
    public void checkBill(){
        System.out.println("=====结账服务=====");
        System.out.println("选择要结账的餐桌号（0退出）");
        int tableId = Utility.readInt();
        if (billService.getPriceById(tableId) != null){
            System.out.println("结账方式（现金/支付宝/微信）：");
            String pay = Utility.readString(50);
            char key = Utility.readConfirmSelection();
            if ( key == 'Y') {
                boolean b = billService.updatePay(tableId, pay);
                if (b == true) {
                    System.out.println("=====结账完成=====");
                }
            }
        }
    }
}
