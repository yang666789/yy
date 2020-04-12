package design_mode.command_study;

import java.util.ArrayList;

/***
 * 请求发送者，只负责发送命令
 * Invoker
 */
public class WaiterInvoker {

    private ArrayList<Command> commands=null;

    public WaiterInvoker(){
        commands=new ArrayList<>();
    }

    public void setCommands(Command command){
        commands.add(command);
    }

    /**
     * 关键是此方法，实现命令的发送，并不执行具体操作
     */
    public void orderUp(){
        System.out.println("有订单");
        for (Command command:commands){
            if (command!=null){
                command.excute();
            }
        }
    }

}
