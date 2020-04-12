package design_mode.memo;

/***
 * 原发器类
 * 可以存储当前的内容状态，也可以使用备忘录来恢复内部状态
 */
public class OriginatorChess {
    private MemotoChess memoChess;

    public OriginatorChess(MemotoChess memoChess) {
        this.memoChess = memoChess;
    }

    public void setX(int x){
        memoChess.setX(x);
    }
    public void setY(int y){
        memoChess.setY(y);
    }

    //备忘录内保存，记录一个当前状态
    public MemotoChess savaMemo(){
        return new MemotoChess(memoChess.getX(),
                memoChess.getY(),
                memoChess.getLabel());
    }

    //恢复状态，恢复当前状态为某一个状态
    public void restore(MemotoChess memoChess){
        this.memoChess.setLabel(memoChess.getLabel());
        this.memoChess.setX(memoChess.getX());
        this.memoChess.setY(memoChess.getY());
    }

    public void show(){
        System.out.println("当前棋子状态："+
                memoChess.getLabel()+"("+
                +memoChess.getX()
                + ","+
                memoChess.getY()+")");
    }
}
