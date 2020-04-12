package design_mode.decorator;

public class Cream extends Decoratoring {

    public Cream(IBirthdayCake iBirthdayCake) {
        super(iBirthdayCake);
    }

    public void putCream(){
        System.out.println("抹上奶油......");
    }
}
