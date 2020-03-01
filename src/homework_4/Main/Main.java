package homework_4.Main;

import homework_4.consrtuct.KFCWaiter;
import homework_4.consrtuct.MealBuilder;
import homework_4.meal.Food.Food;
import homework_4.meal.Food.Humburger;
import homework_4.meal.Food.Pizza;
import homework_4.meal.Meal;
import homework_4.meal.PrototypeManager;
import homework_4.meal.fruit.Apple;
import homework_4.meal.fruit.Banana;
import homework_4.meal.fruit.Fruit;
import homework_4.utils.XMLUtil;

public class Main {

    public static void main(String[] args) {
        try {
            //初始化店铺列表，克隆时直接拿出即可
            PrototypeManager.init();

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
