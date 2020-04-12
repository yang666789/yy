package design_mode.visitor_study;

public class Main {
    public static void main(String[] args) {
        IProduct a1=new Apple();
        IProduct a2=new Apple();
        IProduct b1=new Book();
        AVisitor visitor;

        BuyCar car=new BuyCar();
        car.addProduct(a1);
        car.addProduct(a2);
        car.addProduct(b1);

        try {
            visitor=(AVisitor)XmlUtil.getBean();
            visitor.setName("张三");
            car.accept(visitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
