package homework_3.meal.factory.BFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.fruit.Banana;
import homework_3.meal.fruit.Fruit;

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
