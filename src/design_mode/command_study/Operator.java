package design_mode.command_study;

/***
 * 后台执行者，相当于后厨，做具体操作的人
 * 相当于类图中的Receiver
 */
public class Operator {

    public void makeOrder(Order order){
        String str="";
        for (String componet:order.getMyOrder().keySet()){
            str+=componet+order.getMyOrder().get(componet).toString();
        }
        System.out.println("混合果汁:"+str);
    }
}
