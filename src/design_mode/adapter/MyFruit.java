package design_mode.adapter;

import java.util.Random;

public class MyFruit {

    public String get(){
        Random r=new Random();
        String fruit;
        if (r.nextInt()%2==0){
            fruit="Apple";
        }else
            fruit="Banana";
        return fruit;
    }
}
