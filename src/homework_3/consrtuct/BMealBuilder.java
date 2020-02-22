package homework_3.consrtuct;

import homework_3.meal.factory.BFactory.BFoodFactory;
import homework_3.meal.factory.BFactory.BFruitFactory;

public class BMealBuilder extends MealBuilder {

    @Override
    void getFood() {
        BFoodFactory bFoodFactory=new BFoodFactory();
        getMeal().setbFactory(bFoodFactory);
    }

    @Override
    void getFruit() {
        BFruitFactory bFruitFactory=new BFruitFactory();
        getMeal().setbFactory(bFruitFactory);
    }
}
