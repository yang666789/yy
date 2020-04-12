package design_mode.Bridge.concreteColor;

import design_mode.Bridge.Color;

public class Blue implements Color {
    @Override
    public void bePaint(String penType, String name) {
        System.out.println(penType+"蓝色的"+name);
    }
}
