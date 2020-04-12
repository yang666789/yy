package design_mode.observe.ConcreteSubject;

import design_mode.observe.MyObserve;
import design_mode.observe.MySubject;

public class ConcreteSubjectB extends MySubject {
    @Override
    public void notifyObservrs() {
        System.out.println("B目标发生改变了");
        for (MyObserve observe:observes){
            observe.response();
        }
    }
}
