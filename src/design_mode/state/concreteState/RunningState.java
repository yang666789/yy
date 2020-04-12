package design_mode.state.concreteState;

import design_mode.state.StateSet;
import design_mode.state.ThreadContext;
import design_mode.state.ThreadState;


public class RunningState extends ThreadState {

    public RunningState(){
        state= StateSet.RUNNING;
        System.out.println("运行状态");
    }

    public void suspend(ThreadContext context){
        if (state==StateSet.RUNNING){
            System.out.println("调用了suspend()方法");
            context.setState(new BlockedState());
        }else {
            System.out.println("当前线程不是运行状态");
        }
    }

    public void stop(ThreadContext context){
        if (state==StateSet.RUNNING){
            context.setState(new DeadState());
        }else {
            System.out.println("当前线程不是运行状态");
        }
    }
}
