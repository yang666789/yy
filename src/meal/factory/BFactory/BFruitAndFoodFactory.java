package meal.factory.BFactory;

import meal.Food.Food;
import meal.fruit.Fruit;

public interface BFruitAndFoodFactory {

    Fruit creatFruit();

    Food creatFood();
}
