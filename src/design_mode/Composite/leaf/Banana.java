package design_mode.Composite.leaf;

import design_mode.Composite.MyElement;

public class Banana extends MyElement {
    @Override
    public void eat() {
        System.out.println("吃香蕉");
    }
}
