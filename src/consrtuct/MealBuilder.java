package consrtuct;

import meal.Meal;

public abstract class MealBuilder {

    private Meal meal=new Meal();

    abstract void getFood();

    abstract void getFruit();

    public Meal getMeal(){
        return meal;
    }
}
