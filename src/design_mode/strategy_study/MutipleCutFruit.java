package design_mode.strategy_study;

public class MutipleCutFruit implements ICutFruit {
    @Override
    public void cutFruitStratege(String fruitName) {
        System.out.println(fruitName+"被切成一瓣一瓣的");
    }
}
