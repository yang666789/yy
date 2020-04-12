package design_mode.strategy_study;

public class Chef {

    private ICutFruit cutFruit;

    public void setCutFruit(ICutFruit cutFruit) {
        this.cutFruit = cutFruit;
    }

    public void CutFruit(String name){
        cutFruit.cutFruitStratege(name);
    }

}
