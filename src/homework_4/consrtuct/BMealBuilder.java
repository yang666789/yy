package homework_4.consrtuct;

import homework_4.meal.factory.BFactory.BFoodFactory;
import homework_4.meal.factory.BFactory.BFruitFactory;

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
