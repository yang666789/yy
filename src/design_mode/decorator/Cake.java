package design_mode.decorator;

public class Cake implements IBirthdayCake{
    public Cake(){
        System.out.println("蛋糕坯被生成");
    }

    @Override
    public void show() {
        System.out.println("蛋糕坯");
    }
}
