package design_mode.adapter;

/***
 * 适配器类:采用类的方式实现（还有对象的，不继承老的，而是依赖）
 *
 * 优点：将目标类和适配者类解耦，引入适配器类重用现有适配者类
 *      增加了类的透明性和复用性，具体实现在适配者类中
 *      灵活性与扩展性好，通过更改配置文件可以方便更换适配器，也可以不修改原有代码下增加新适配器类，符合开闭原则
 *
 * 适用场景：系统需要使用现有的类，而这些类的接口不符合系统的需求
 *          想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类一起工作（为适应新伙伴，自己需要重用）
 *
 */
public class Adapter extends OldJuicer implements NewJuicer {

    @Override
    public String newPort(MyFruit fruit1, MyFruit fruit2) {
        String str="混合果汁:"+oldPort(fruit1);
        str+="和"+oldPort(fruit2);
        return str;
    }
}
