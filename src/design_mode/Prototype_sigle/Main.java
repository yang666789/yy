package design_mode.Prototype_sigle;

public class Main {
    public static void main(String[] args) {
//        MyFruit fruit1=new Apple();
//        //此时是同一个东西，地址内容都一样
//        //MyFruit fruit2=fruit1;
//        MyFruit fruit2=(Apple)fruit1.clone();//内容一样，但是地址不一样
//        fruit1.display();
//        fruit2.display();
//
//        System.out.println(fruit1.hashCode());
//        System.out.println(fruit2.hashCode());
//        System.out.println(fruit1==fruit2);

        MyFruit fruit1=new Apple();
        MyFruit fruit2=new Banana();

        MyFruitStore mfs1=MyFruitStore.getFruitStore();
        mfs1.addStore(0,fruit1);
        mfs1.addStore(1,fruit2);
        mfs1.addStore(2,new Apple());
        mfs1.addStore(3,new Banana());
        MyFruitStore mfs2=MyFruitStore.getFruitStore();

        //类似于从游戏商城买东西，只是复制武器基本属性
        MyFruit fruit5=mfs1.get(3);
        fruit5.display();
        System.out.println(mfs1.toString());
        System.out.println(mfs2.toString());
//        MyFruit fruit6=mfs1.get(3);
//
//        System.out.println(fruit5.hashCode());
//        System.out.println(fruit6.hashCode());
//        System.out.println(fruit5==fruit6);
    }

}
