package design_mode.Bridge.concretePen;

import design_mode.Bridge.Pen;

public class BigPen extends Pen {
    @Override
    public void draw(String name) {
        String penType="大号笔绘制";
        this.color.bePaint(penType,name);
    }
}
