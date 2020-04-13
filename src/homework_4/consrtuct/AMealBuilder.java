package homework_4.consrtuct;

import homework_4.meal.factory.AFactory.AFoodFactory;
import homework_4.meal.factory.AFactory.AFruitFactory;

public class AMealBuilder extends MealBuilder {

    @Override
    void getFood() {
        AFoodFactory aFoodFactory=new AFoodFactory();
        getMeal().setaFactory(aFoodFactory);
    }

    @Override
    void getFruit() {
        AFruitFactory aFruitFactory=new AFruitFactory();
        getMeal().setaFactory(aFruitFactory);
    }
}
