package design_mode.decorator;

public class Fruit extends Decoratoring {

    public Fruit(IBirthdayCake iBirthdayCake) {
        super(iBirthdayCake);
    }

    public void putFruit(){
        System.out.println("加水果......");
    }
}
