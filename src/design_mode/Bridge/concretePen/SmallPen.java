package design_mode.Bridge.concretePen;

import design_mode.Bridge.Pen;

public class SmallPen extends Pen {
    @Override
    public void draw(String name) {
        String penType="小号笔绘制";
        this.color.bePaint(penType,name);
    }
}
