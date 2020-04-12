package design_mode.observe.ConcretObserve;

import design_mode.observe.MyObserve;

public class ConcreteObserve2 implements MyObserve {
    @Override
    public void response() {
        System.out.println("目标发生变化了，观察者2的反应");
    }
}
