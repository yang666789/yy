package design_mode.command_study;

public class Client {

    /**
     *  消除请求接收者和请求发送者之间的耦合，采用命令模式设计
     */
    public static void main(String[] args) {
        //1.创建多个订单
        Order order1=new Order();
        order1.setId(1);
        order1.setMyOrder("苹果",1);
        order1.setMyOrder("香蕉",2);
        order1.setMyOrder("李子",3);

        Order order2=new Order();
        order2.setId(2);
        order2.setMyOrder("西瓜",1);
        order2.setMyOrder("葡萄",2);
        order2.setMyOrder("车厘子",3);
        //2.创建操作者
        Operator operator=new Operator();
        //3.将多个订单封装成命令对象
        ConcretCommand cmd1=new ConcretCommand(order1,operator);
        ConcretCommand cmd2=new ConcretCommand(order2,operator);
        //4.创建调用者并加命令
        WaiterInvoker waiter=new WaiterInvoker();
        waiter.setCommands(cmd1);
        waiter.setCommands(cmd2);
        //5.执行命令
        waiter.orderUp();
    }
}
