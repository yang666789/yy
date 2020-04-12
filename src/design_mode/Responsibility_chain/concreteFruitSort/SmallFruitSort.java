package design_mode.Responsibility_chain.concreteFruitSort;

import design_mode.Responsibility_chain.AbstractFruitSort;

public class SmallFruitSort extends AbstractFruitSort {
    public SmallFruitSort(int weight) {
        super(weight);
    }

    @Override
    protected void pushBox(String fruit) {
        fruitBox.add("打果汁："+fruit);
    }
}
