package design_mode.shareElement;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PieceFactory factory=new PieceFactory();

        Random r=new Random();
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                APiece aPiece;
                if (r.nextInt()%2==0)
                    aPiece=factory.getPiece("白棋");
                else
                    aPiece=factory.getPiece("黑棋");
                aPiece.play(r.nextInt(19),r.nextInt(19));
            }
        }
        System.out.println("总共棋子的对象个数是："+factory.getPiecesCount());
    }
}
