package design_mode.Bridge.concretePen;

import design_mode.Bridge.Pen;

public class MiddlePen extends Pen {
    @Override
    public void draw(String name) {
        String penType="中号笔绘制";
        this.color.bePaint(penType,name);
    }
}
