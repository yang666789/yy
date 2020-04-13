package homework_4.meal.factory.AFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.PrototypeManager;
import homework_4.meal.fruit.Apple;
import homework_4.meal.fruit.Fruit;

public class AFruitFactory implements AFruitAndFoodFactory {

    @Override
    public Fruit creatFruit() throws CloneNotSupportedException {
        return PrototypeManager.getFruit(0);
    }

    @Override
    public Food creatFood() {return null;};
}
