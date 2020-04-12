package design_mode.appearance;

import design_mode.appearance.item.Air;
import design_mode.appearance.item.Fan;
import design_mode.appearance.item.Light;
import design_mode.appearance.item.Television;

/***
 * 外观模式：外观类（用户与子系统间的复杂关系由外观角色实现）
 * 优点：对客户屏蔽子系统组件，使客户端代码变得简单
 *      实现了子系统与客户间的松耦合关系，子系统组件的变化不会影响到调用它的客户类，只需要调整外观类即可
 *      ***降低了大型软件系统中的编译依赖性，一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化不会影响到外观对象
 *      只是提供了一个访问子系统的统一接口，并不会影响用户直接使用子系统类
 * 缺点：不能很好的限制客户使用子系统类，如果客户访问子系统类做太多限制则减少了可变性与灵活性
 *      在不引入抽象外观类的情况下，增加新的子系统会修改外观类或客户端的代码，违背了“开闭原则”（增加新的对象，因为外观类依赖对象，所以要打开并添加)
 *
 * 适用场景：为复杂子系统提供简单接口时，用户也可以绕过外观类直接访问子系统
 *          客户程序与多个子系统间有很大依赖性时，可以使用来解耦
 *          在层次化结构中，可以使用外观模式定义系统每一层的入口，层与层间通过外观类联系
 *
 * 注意：与单例模式结合，在系统中只有一个外观对象
 *      不要让外观类对象做过多额外工作，本身功能点必须在各个子系统内完成，***而外观可以发生改变，有百变的外壳
 */
public class GenaralSwitch {
    private Light[] lights=new Light[4];
    private Fan fan;
    private Air air;
    private Television tv;

    public GenaralSwitch(){
        lights[0]=new Light("前");
        lights[1]=new Light("后");
        lights[2]=new Light("左");
        lights[3]=new Light("右");
        fan=new Fan();
        air=new Air();
        tv=new Television();
    }

    public void on(){
        for(Light light:lights){
            light.on();
        }
        fan.on();
        air.on();
        tv.on();
    }

    public void off(){
        for (Light light:lights){
            light.off();
        }
        fan.off();
        air.off();
        tv.off();
    }
}
