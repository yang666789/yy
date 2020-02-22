package homework_3.meal.factory.AFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.Food.Humburger;
import homework_3.meal.fruit.Fruit;

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
