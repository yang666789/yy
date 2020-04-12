package design_mode.strategy_study;

public class KnifeCutFruit implements ICutFruit {
    @Override
    public void cutFruitStratege(String fruitName) {
        System.out.println(fruitName+"被切成一片一片的");
    }
}
