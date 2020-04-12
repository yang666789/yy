package design_mode.adapter;

//适配者
public class OldJuicer {

    //只能榨一个水果
    public String oldPort(MyFruit fruit){
        return fruit.get()+"果汁";
    }
}
