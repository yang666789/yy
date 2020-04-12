package design_mode.Responsibility_chain;

import java.util.ArrayList;
import java.util.List;

/***
 * 职责链模式：将请求发送者与处理者解耦，客户并不知道谁处理了请求，只需将请发送到链上即可
 * 不允许某个处理者对象承担了一部分责任后将责任向下传的情况，禁止糅合
 * 不纯职责链内一个请求可以不被任何接受端对象接受
 *
 * 优点：降低耦合度（每个具体成员处理的耦合度，每个具体成员有自己单独的处理方法）
 *      简化对象之间的相互连接
 *      增强给对象指派职责的灵活性（可以在已有具有职责对象中再去扩展职责）
 *      增加新的请求处理方法很灵活
 * 缺点：不能保证请求一定被接收（有的水果被漏掉了）
 *      代码调试不方便，可能会造成循环调用（配置职责链或者new对象时出错不容易找出来）
 *
 * 适用场景：有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定
 * eg:java中的try...catch，有很多个catch能处理try捕捉的异常
 *    js中的冒泡
 */
public abstract class AbstractFruitSort {
    private int weight;
    protected List<String> fruitBox;
    private AbstractFruitSort nextFruitSort;

    public AbstractFruitSort(int weight){
        this.weight=weight;
        fruitBox=new ArrayList<>();
    }

    public void getFruit(){
        System.out.print("Weight:"+weight);
        System.out.println("kg的水果个数："+fruitBox.size());
        for (String fruit:fruitBox){
            System.out.print(fruit+",");
        }
        System.out.println(" ");
    }

    //配备职责链函数
    public void setNextFruitSort(AbstractFruitSort nextFruitSort){
        this.nextFruitSort=nextFruitSort;
    }

    //水果匹配比较过程
    public void pushFruit(int weight,String fruit){
        if (weight>=this.weight){
            pushBox(fruit);
        }else if (nextFruitSort!=null){
            nextFruitSort.pushFruit(weight,fruit);
        }
    }

    //由子类去实现，分拣匹配成功后对水果进行的具体操作
    protected abstract void pushBox(String fruit);
}
