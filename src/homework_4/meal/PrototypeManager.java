package homework_4.meal;


import homework_4.meal.Food.Food;
import homework_4.meal.Food.Humburger;
import homework_4.meal.Food.Pizza;
import homework_4.meal.fruit.Apple;
import homework_4.meal.fruit.Banana;
import homework_4.meal.fruit.Fruit;

import java.util.Hashtable;

public class PrototypeManager {

    private static Hashtable<Integer, Food> foodStore=new Hashtable<>();
    private static Hashtable<Integer, Fruit> fruitStore=new Hashtable<>();

    public static void addFood(Integer key,Food food){
        foodStore.put(key,food);
    }

    public static Food getFood(Integer key) throws CloneNotSupportedException {
        Food food=foodStore.get(key);
        return (Food) food.clone();
    }

    public static void addFruit(Integer key,Fruit fruit){
        fruitStore.put(key,fruit);
    }

    public static Fruit getFruit(Integer key) throws CloneNotSupportedException {
        Fruit fruit=fruitStore.get(key);
        return (Fruit) fruit.clone();
    }

    public static void init(){
        //初始化往原型管理器中添加商品
        Food food1=new Humburger();
        Food food2=new Pizza();
        Fruit fruit1=new Apple();
        Fruit fruit2=new Banana();
        addFood(0,food1);
        addFood(1,food2);
        addFruit(0,fruit1);
        addFruit(1,fruit2);
    }
}
