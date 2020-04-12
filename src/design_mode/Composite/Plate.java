package design_mode.Composite;

import java.util.ArrayList;
import java.util.List;

/***
 * 分为透明组合：add和remove在抽象构件中
 *     安全组合：add和remove在容器中
 *
 * 优点：清楚定义分层次的复杂对象，增加新的构件很容易
 *      客户端调用简单
 *      不断地递归可以形成复杂的树形结构
 * 缺点：使设计变得更抽象，要同时把握叶子和容器的共性抽象出来，当业务复杂时难以实现
 *
 * 适用场景：在具有整体和部分的层次结构中，希望忽略整体与部分的差异
 *          使客户忽略不同对象层次变化，针对抽象构建编程，无须关心细节
 *          对象复杂程度不一样，但客户需要一致地处理它们
 */
public class Plate extends MyElement {
    private List<MyElement> elements= new ArrayList<>();

    public void add(MyElement element){
        elements.add(element);
    }

    public void remove(MyElement element){
        elements.remove(element);
    }

    @Override
    public void eat() {
        for (MyElement element:elements){
            element.eat();
        }
    }
}
