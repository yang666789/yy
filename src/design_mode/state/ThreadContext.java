package design_mode.state;

import design_mode.state.concreteState.*;

/***
 * 环境类
 * 优点：
 *      状态模式使不同状态的行为分隔开，满足单一职责原则（即每个状态只做一件事情）
 *      减少对象间相互依赖，不同状态引入到独立对象中，使状态转换更明确
 *      有利于扩展，定义新的子类很容易增加新的状态和转换（但是要跟原有的状态转换要兼容，和其他状态要交互，不能独立）
 * 缺点：
 *      会增加类和对象的个数
 *      状态结构实现很复杂，如果使用不当会导致程序结构和代码混乱（所以要实现了解状态转换关系）
 */
public class ThreadContext {
    ThreadState state;
    ThreadContext(){
        state=new NewState();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start(){
        ((NewState)state).start(this);
    }

    public void getCPU(){
        ((RunnableState)state).getCPU(this);
    }

    public void suspend(){
        ((RunningState)state).suspend(this);
    }

    public void resume(){
        ((BlockedState)state).resume(this);
    }

    public void stop(){
        ((RunningState)state).stop(this);
    }
}
