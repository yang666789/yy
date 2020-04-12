package design_mode.state.concreteState;

import design_mode.state.StateSet;
import design_mode.state.ThreadContext;
import design_mode.state.ThreadState;

public class RunnableState extends ThreadState {

    public RunnableState(){
        state= StateSet.RUNNABLE;
        System.out.println("线程就绪");
    }

    public void getCPU(ThreadContext context){
        System.out.println("调用了getCPU()方法");
        if (state==StateSet.RUNNABLE){
            context.setState(new RunningState());
        }else {
            System.out.println("当前线程不是就绪状态");
        }
    }
}
