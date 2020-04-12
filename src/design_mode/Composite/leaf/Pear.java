package design_mode.Composite.leaf;

import design_mode.Composite.MyElement;

public class Pear extends MyElement {
    @Override
    public void eat() {
        System.out.println("吃梨子");
    }
}
