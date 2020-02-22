package homework_3.meal.factory.BFactory;

import homework_3.meal.Food.Food;
import homework_3.meal.fruit.Fruit;

public interface BFruitAndFoodFactory {

    Fruit creatFruit();

    Food creatFood();
}
