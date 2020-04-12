package design_mode.memo;

/***
 * 后悔药
 */
public class Client {
    public static void main(String[] args) {
        OriginatorChess originator=new OriginatorChess(
                new MemotoChess(3,3,"黑棋"));
        play(originator);
        originator.setX(4);
        play(originator);
        originator.setY(5);
        play(originator);

        undo(originator,index);
        undo(originator,index);
        redo(originator);
        redo(originator);
    }

    private static int index=0;
    private static CareTakerChess careTakerChess=new CareTakerChess();

    public static void play(OriginatorChess chess){
        index++;
        careTakerChess.addMemos(chess.savaMemo());
        chess.show();
    }

    public static void undo(OriginatorChess chess,int i){
        System.out.println("***********悔棋***********");
        index--;
        chess.restore(careTakerChess.getMemos(index-1));
        chess.show();
    }

    public static void redo(OriginatorChess chess){
        System.out.println("***********撤销悔棋***********");
        chess.restore(careTakerChess.getMemos(index));
        index++;
        chess.show();
    }
}
