package design_mode.Composite;

import design_mode.Composite.leaf.Apple;
import design_mode.Composite.leaf.Banana;
import design_mode.Composite.leaf.Pear;

public class Main {
    public static void main(String[] args) {
        MyElement a1,a2,b1,b2,pear;
        Plate p1,p2,p3;

        a1=new Apple();
        a2=new Apple();
        p1=new Plate();
        p1.add(a1);
        p1.add(a2);

        b1=new Banana();
        b2=new Banana();
        p2=new Plate();
        p2.add(b1);
        p2.add(b2);

        pear=new Pear();
        p3=new Plate();
        p3.add(pear);
        p3.add(p1);
        p3.add(p2);

        p3.eat();
    }
}
