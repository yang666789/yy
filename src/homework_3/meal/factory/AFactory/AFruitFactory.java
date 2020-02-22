package homework_3.meal.factory.AFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.fruit.Apple;
import homework_3.meal.fruit.Fruit;

public class AFruitFactory implements AFruitAndFoodFactory {

    @Override
    public Fruit creatFruit() {
        return new Apple();
    }

    @Override
    public Food creatFood() {return null;};
}
