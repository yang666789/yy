package meal.factory.BFactory;

import meal.Food.Food;
import meal.Food.Pizza;
import meal.fruit.Fruit;

public class BFoodFactory implements BFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() {
        return null;
    }

    @Override
    public Food creatFood() {
        return new Pizza();
    }
}
