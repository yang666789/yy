package homework_4.meal.factory.BFactory;

import homework_4.meal.Food.Food;
import homework_4.meal.fruit.Fruit;

public interface BFruitAndFoodFactory {

    Fruit creatFruit() throws CloneNotSupportedException;

    Food creatFood() throws CloneNotSupportedException;
}
