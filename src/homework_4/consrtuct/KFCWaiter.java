package homework_4.consrtuct;

import homework_4.meal.Meal;

public class KFCWaiter {

    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct(){
        mealBuilder.getFood();
        mealBuilder.getFruit();
        return mealBuilder.getMeal();
    }
}
