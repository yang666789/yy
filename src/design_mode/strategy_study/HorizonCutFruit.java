package design_mode.strategy_study;

public class HorizonCutFruit implements ICutFruit {
    @Override
    public void cutFruitStratege(String fruitName) {
        System.out.println(fruitName+"被切成一块一块的");
    }
}
