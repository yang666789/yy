package design_mode.command_study;

import java.util.HashMap;

/***
 * 订单类，每个订单有一个订单号以及订单里含有具体东西
 */
public class Order {

    private int id;
    private HashMap<String,Integer> myOrder=null;

    public Order(){
        myOrder=new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String, Integer> getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(String componet,int num) {
        myOrder.put(componet,num);
    }
}
