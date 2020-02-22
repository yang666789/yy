package consrtuct;

import meal.factory.BFactory.BFoodFactory;
import meal.factory.BFactory.BFruitFactory;

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
