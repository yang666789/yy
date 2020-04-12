package design_mode.state.concreteState;

import design_mode.state.StateSet;
import design_mode.state.ThreadContext;
import design_mode.state.ThreadState;

public class NewState extends ThreadState {

     public NewState(){
        state= StateSet.NEW;
        System.out.println("新建线程");
    }

    public void start(ThreadContext context){
        System.out.println("调用了start()方法");
        if(state==StateSet.NEW){
            context.setState(new RunnableState());
        }else {
            System.out.println("当前线程不是新建状态");
        }
    }
}
