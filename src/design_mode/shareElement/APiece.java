package design_mode.shareElement;

//抽象享元类
public abstract class APiece {
    String inkind;
    public APiece(String inkind){
        this.inkind=inkind;
    }

    public abstract void play(int x,int y);
}
