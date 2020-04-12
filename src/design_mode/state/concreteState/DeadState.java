package design_mode.state.concreteState;

import design_mode.state.StateSet;
import design_mode.state.ThreadState;

public class DeadState extends ThreadState {
    public DeadState(){
        state= StateSet.DEAD;
        System.out.println("线程死亡");
    }
}
