package design_mode.Prototype_sigle;

/***
 * 原型模式：复制一个对象自身，从而克隆出多个与原型对象一模一样的对象
 *          适用于创建较复杂的，频繁创建的对象，new的时候开销很大
 */
public class MyFruit implements Cloneable {
    protected String kind;

    public void display(){
        System.out.println(kind);
    }

    @Override
    public Object clone(){
        Object o=null;
        try {
            o=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}
