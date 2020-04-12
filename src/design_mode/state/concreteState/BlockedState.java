package design_mode.state.concreteState;

import design_mode.state.StateSet;
import design_mode.state.ThreadContext;
import design_mode.state.ThreadState;

public class BlockedState extends ThreadState {

    public BlockedState(){
        state= StateSet.BLOCKED;
        System.out.println("阻塞状态");
    }

    public void resume(ThreadContext context){
        if (state==StateSet.BLOCKED){
            context.setState(new RunnableState());
        }else {
            System.out.println("当前线程不是阻塞状态");
        }
    }
}
