package design_mode.memo;

import java.util.ArrayList;

/***
 * 管理者
 * 复制保存备忘录，但是不能对其内容进行修改或者检查，只负责存储多个备忘录对象
 * 无需知道对象的实现细节
 */
public class CareTakerChess {
    private ArrayList<MemotoChess> memos=new ArrayList<>();

    public MemotoChess getMemos(int i) {
        return memos.get(i);
    }

    public void addMemos(MemotoChess memo) {
        memos.add(memo);
    }
}
