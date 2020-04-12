package design_mode.Responsibility_chain.concreteFruitSort;

import design_mode.Responsibility_chain.AbstractFruitSort;

public class MiddleFruitSort extends AbstractFruitSort {
    public MiddleFruitSort(int weight) {
        super(weight);
    }

    @Override
    protected void pushBox(String fruit) {
        fruitBox.add("水果罐头："+fruit);
    }
}
