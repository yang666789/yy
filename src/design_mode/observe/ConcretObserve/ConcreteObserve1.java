package design_mode.observe.ConcretObserve;

import design_mode.observe.MyObserve;

public class ConcreteObserve1 implements MyObserve {
    @Override
    public void response() {
        System.out.println("目标发生改变了，观察者1的反应");
    }
}
