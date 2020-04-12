package design_mode.visitor_study;

/***
 * 对访问者的扩展很友好，但是对产品类的扩展不友好，因为增加一个产品类，
 * 该抽象类就要修改代码，造成开闭原则的倾斜性
 * 类似于超市，商品线不怎么变化，而访问商品的人却各色各样
 */
public abstract class AVisitor {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    abstract void visit(Apple apple);

    abstract void visit(Book book);
}
