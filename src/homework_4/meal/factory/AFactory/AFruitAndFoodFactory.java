package homework_4.meal.factory.AFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.fruit.Fruit;

public interface AFruitAndFoodFactory {

    Fruit creatFruit() throws CloneNotSupportedException;

    Food creatFood() throws CloneNotSupportedException;
}
