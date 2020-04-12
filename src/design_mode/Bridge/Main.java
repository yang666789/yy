package design_mode.Bridge;

import design_mode.Bridge.util.XmlUtil;

/***
 * 桥接模式：将抽象与实现分离，使它们可以独立变化，组合代替继承，降低了抽象与实现这两个可变维度的耦合
 *          两个维度在变化的事物，又想把他们糅合在一起用的时候
 *
 * 优点：抽象与实现分离，扩展能力强
 *      实现细节对客户透明
 * 缺点：要求开发者针对抽象化进行设计与编程，增加了系统理解与设计难度
 *
 * 即越容易扩展的东西抽象性越好，理解起来越难
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Color color;
        Pen pen;

        color=(Color) XmlUtil.getBean("color");
        pen=(Pen) XmlUtil.getBean("pen");

        pen.setColor(color);
        pen.draw("火影忍者");
    }
}
