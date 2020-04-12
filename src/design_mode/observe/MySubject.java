package design_mode.observe;

import java.util.ArrayList;
import java.util.List;

//目标
public abstract class MySubject {
    public List<MyObserve> observes;
    public MySubject(){
        observes=new ArrayList<>();
    }

    public void add(MyObserve observe){
        observes.add(observe);
    }

    public void remove(MyObserve observe){
        observes.remove(observe);
    }

    public abstract void notifyObservrs();
}
