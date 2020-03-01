package homework_4.meal.factory.BFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.PrototypeManager;
import homework_4.meal.fruit.Banana;
import homework_4.meal.fruit.Fruit;

public class BFruitFactory implements BFruitAndFoodFactory {
    @Override
    public Fruit creatFruit() throws CloneNotSupportedException {
        return PrototypeManager.getFruit(1);
    }

    @Override
    public Food creatFood() {
        return null;
    }
}
