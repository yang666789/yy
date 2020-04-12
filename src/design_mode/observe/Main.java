package design_mode.observe;

import design_mode.observe.ConcretObserve.ConcreteObserve1;
import design_mode.observe.ConcretObserve.ConcreteObserve2;
import design_mode.observe.ConcreteSubject.ConcreteSubjectB;

/***
 * 观察者模式：适用于对象间存在一对多关系，一个对象状态的改变会影响其他对象
 *            一个抽象模型有两个方面，其中一个方面依赖于另一个方面，可以将二者封装在独立的对象中
 * 推模式：将自己的改变主动通知给别人，不管别人要不要
 * 拉模式：观察者被通知，然后响应时拉取变化的目标数据
 *
 * eg:MVC模式
 * 优点：降低目标与观察者的耦合，两者是抽象耦合关系
 *      目标和观察者间建立了一套触发机制（目标改变，触发通知）
 * 缺点：目标与观察者间的依赖没有完全解除，可以出现循环引用（如你观察我，我观察你）
 *      当观察者对象很多时，发布通知费时间，影响程序效率
 */
public class Main {
    public static void main(String[] args) {
        MySubject subject=new ConcreteSubjectB();
        MyObserve observe1=new ConcreteObserve1();
        MyObserve observe2=new ConcreteObserve2();
        subject.add(observe1);
        subject.add(observe2);
        subject.notifyObservrs();
    }
}
