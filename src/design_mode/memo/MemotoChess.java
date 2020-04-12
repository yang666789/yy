package design_mode.memo;

/***
 * 备忘录类
 * 注意：除了原发器类和负责人类之外，备忘录类不能供其他类使用
 */
public class MemotoChess {
    private int x,y;
    private String label;

    public MemotoChess(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
