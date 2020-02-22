package meal.factory.AFactory;

import meal.Food.Food;
import meal.fruit.Fruit;

public interface AFruitAndFoodFactory {

    Fruit creatFruit();

    Food creatFood();
}
