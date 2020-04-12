package design_mode.decorator;

public class Main {
    public static void main(String[] args) {
        IBirthdayCake iBirthdayCake=new Cake();
        iBirthdayCake.show();
        Cream cream=new Cream(iBirthdayCake);
        cream.putCream();
        Fruit fruit=new Fruit(cream);
        fruit.putFruit();
        fruit.show();
    }
}
