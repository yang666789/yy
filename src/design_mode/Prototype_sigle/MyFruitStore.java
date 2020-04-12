package design_mode.Prototype_sigle;

import java.util.Hashtable;

/**
 * 原型管理器
 * 单例模式：懒汉式：如下所示，调用函数时才new，适用于系统启动完，有必要时候再new
 *          饿汉式：成员直接new，然后调用函数时直接返回对象即可，适用于系统启动时需要全部加载完时
 */
public class MyFruitStore {

    private static Hashtable<Integer,MyFruit> fruitTable=null;
    private static MyFruitStore fruitStore;

    public static MyFruitStore getFruitStore(){
        if (fruitStore==null){
            fruitStore=new MyFruitStore();
        }
        return fruitStore;
    }

    private MyFruitStore(){
        fruitTable=new Hashtable<>();
    }

    public void addStore(Integer key,MyFruit fruit){
        fruitTable.put(key,fruit);
    }

    public MyFruit get(Integer key){
        MyFruit fruit=fruitTable.get(key);
        return (MyFruit) fruit.clone();
    }
}
