package homework_3.consrtuct;

import homework_3.meal.Meal;

public abstract class MealBuilder {

    private Meal meal=new Meal();

    abstract void getFood();

    abstract void getFruit();

    public Meal getMeal(){
        return meal;
    }
}
