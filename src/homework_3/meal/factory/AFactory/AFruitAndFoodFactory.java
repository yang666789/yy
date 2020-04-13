package homework_3.meal.factory.AFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.fruit.Fruit;

public interface AFruitAndFoodFactory {

    Fruit creatFruit();

    Food creatFood();
}
