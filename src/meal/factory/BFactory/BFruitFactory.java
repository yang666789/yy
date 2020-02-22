package meal.factory.BFactory;

import meal.Food.Food;
import meal.fruit.Banana;
import meal.fruit.Fruit;

public class BFruitFactory implements BFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() {
        return new Banana();
    }

    @Override
    public Food creatFood() {
        return null;
    }
}
