package homework_4.meal.factory.BFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.Food.Pizza;
import homework_4.meal.PrototypeManager;
import homework_4.meal.fruit.Fruit;

public class BFoodFactory implements BFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() {
        return null;
    }

    @Override
    public Food creatFood() throws CloneNotSupportedException {
        return PrototypeManager.getFood(1);
    }
}
