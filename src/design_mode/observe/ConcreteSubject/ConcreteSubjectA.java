package design_mode.observe.ConcreteSubject;

import design_mode.observe.MyObserve;
import design_mode.observe.MySubject;

public class ConcreteSubjectA extends MySubject {
    @Override
    public void notifyObservrs() {
        System.out.println("A目标发生改变了");
        for (MyObserve observe:observes){
            observe.response();
        }
    }
}
