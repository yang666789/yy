package homework_3.meal;

import homework_3.meal.factory.AFactory.AFruitAndFoodFactory;
import homework_3.meal.factory.BFactory.BFruitAndFoodFactory;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    /*一个接口列表里存放多个实现工厂，相当于一个套餐里含有多个东西
    * 因为一个接口工厂有多个实现类，这样就可以记录多个实现，
    * 在主函数调用抽象接口时，不至于实现类被覆盖*/
    private List<AFruitAndFoodFactory> aFactory=new ArrayList<>();
    private List<BFruitAndFoodFactory> bFactory=new ArrayList<>();

    public List<AFruitAndFoodFactory> getaFactory() {
        return aFactory;
    }

    public void setaFactory(AFruitAndFoodFactory aFactory) {
        this.aFactory.add(aFactory);
    }

    public List<BFruitAndFoodFactory> getbFactory() {
        return bFactory;
    }

    public void setbFactory(BFruitAndFoodFactory bFactory) {
        this.bFactory.add(bFactory);
    }
}
