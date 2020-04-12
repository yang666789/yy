package design_mode.command_study;

/***
 * 封装命令，将订单和操作员封装起来
 */
public class ConcretCommand implements Command {

    private Order order;
    private Operator operator;

    public ConcretCommand(Order order,Operator operator){
        this.order=order;
        this.operator=operator;
    }

    @Override
    public void excute() {
        System.out.println(order.getId()+"号订单做好了：");
        operator.makeOrder(order);
    }
}
