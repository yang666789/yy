package meal.factory.AFactory;

import meal.Food.Food;
import meal.fruit.Apple;
import meal.fruit.Fruit;

public class AFruitFactory implements AFruitAndFoodFactory {

    @Override
    public Fruit creatFruit() {
        return new Apple();
    }

    @Override
    public Food creatFood() {return null;};
}
