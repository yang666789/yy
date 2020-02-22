package meal.factory.AFactory;

import meal.Food.Food;
import meal.Food.Humburger;
import meal.fruit.Fruit;

public class AFoodFactory implements AFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() {
        return null;
    }

    @Override
    public Food creatFood() {
        return new Humburger();
    }
}
