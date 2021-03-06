package homework_3.Main;

import homework_3.consrtuct.KFCWaiter;
import homework_3.consrtuct.MealBuilder;
import homework_3.meal.Meal;
import homework_3.utils.XMLUtil;

public class Main {

    public static void main(String[] args) {
        try {
            MealBuilder mb=(MealBuilder) XMLUtil.getBean();
            KFCWaiter waiter=new KFCWaiter();
            waiter.setMealBuilder(mb);
            Meal meal=waiter.construct();

            System.out.println("你点的套餐是：");
            //选中B套餐
            if(meal.getaFactory().size()==0){
                meal.getbFactory().get(0).creatFood().getFood();
                meal.getbFactory().get(1).creatFruit().getFruit();
            }
            //选中A套餐
            else {
                meal.getaFactory().get(0).creatFood().getFood();
                meal.getaFactory().get(1).creatFruit().getFruit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
