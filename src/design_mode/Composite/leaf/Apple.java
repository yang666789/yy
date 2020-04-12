package design_mode.Composite.leaf;

import design_mode.Composite.MyElement;

public class Apple extends MyElement {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
