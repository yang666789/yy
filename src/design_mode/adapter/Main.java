package design_mode.adapter;

public class Main {
    public static void main(String[] args) {
        NewJuicer newJuicer=new Adapter();
        MyFruit fruit=new MyFruit();
        System.out.println(newJuicer.newPort(fruit,fruit));
    }
}
