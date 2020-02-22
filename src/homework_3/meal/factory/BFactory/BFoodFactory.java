package homework_3.meal.factory.BFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.Food.Pizza;
import homework_3.meal.fruit.Fruit;

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
