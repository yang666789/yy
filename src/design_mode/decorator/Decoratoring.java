package design_mode.decorator;

/***
 * 装饰模式
 * 优点：此模式与继承关系目的是扩展对象的功能，但比继承更灵活，符合合成复用原则
 *      动态扩展对象功能，可以通过配置文件在运行时选择不同的装饰器
 *      具体装饰类和具体构建类可以独立变化，符合“开闭原则”
 * 缺点：装饰时要new出很多具体装饰类对象，会增加系统的复杂度
 *      装饰一层套一层，调试麻烦
 *
 * 应用场景：以透明、动态方式给单个对象添加职责（不改变被装饰的构件，而添加装饰来为原构件添加职责）
 *          需要动态给对象增加功能或者撤销
 *          继承扩展功能麻烦可考虑装饰模式
 */
public class Decoratoring  implements IBirthdayCake{
    //最重要的，把装饰实体的引用放进来
    private IBirthdayCake iBirthdayCake;

    public Decoratoring(IBirthdayCake iBirthdayCake) {
        this.iBirthdayCake = iBirthdayCake;
    }

    @Override
    public void show() {
        iBirthdayCake.show();
    }
}
