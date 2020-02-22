package consrtuct;

import meal.Meal;

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
