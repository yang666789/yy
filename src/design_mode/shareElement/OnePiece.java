package design_mode.shareElement;

//具体享元类
public class OnePiece extends APiece {
    public OnePiece(String inkind) {
        super(inkind);
    }

    @Override
    public void play(int x, int y) {
        System.out.println("把"+inkind+"子放在（"+x+","+y+")");
    }
}
