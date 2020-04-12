package design_mode.strategy_study;

/***
 * 客户端来选择具体的策略，要明白各个策略之间的差异
 * 注意与状态模式进行区分
 */
public class Client {
    public static void main(String[] args) {
        Chef chef=new Chef();
        ICutFruit cut=new MutipleCutFruit();
        chef.setCutFruit(cut);
        chef.CutFruit("苹果");
    }
}
