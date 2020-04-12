package design_mode.appearance.item;

public class Light {
    private String name;
    public Light(String name){
        this.name=name;
    }

    public void on(){
        System.out.println(name+"灯被打开了");
    }

    public void off(){
        System.out.println(name+"灯被关闭了");
    }
}
