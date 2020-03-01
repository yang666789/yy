package homework_4.meal.factory.AFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.PrototypeManager;
import homework_4.meal.fruit.Fruit;

public class AFoodFactory implements AFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() {
        return null;
    }

    @Override
    public Food creatFood() throws CloneNotSupportedException {
        return PrototypeManager.getFood(0);
    }
}
