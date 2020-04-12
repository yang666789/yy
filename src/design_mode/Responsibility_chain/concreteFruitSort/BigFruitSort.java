package design_mode.Responsibility_chain.concreteFruitSort;

import design_mode.Responsibility_chain.AbstractFruitSort;

public class BigFruitSort extends AbstractFruitSort {
    public BigFruitSort(int weight) {
        super(weight);
    }

    @Override
    protected void pushBox(String fruit) {
        fruitBox.add("超市："+fruit);
    }
}
