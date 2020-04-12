package design_mode.shareElement;

import java.util.HashMap;

/***
 * 享元工厂类：管理和存储享元（细粒度对象，轻量级模式）
 * 优点：只是用少量的对象，而这些对象很相似，状态变化小，可以实现对象多次复用
 *      节约内存空间，提高性能
 * 缺点：提高了系统复杂性，需要分离出内部状态（不变的）和外部状态（变的），外部状态具有固化特性，不应该随内部改变而改变
 *
 * 适用场景：系统有大量对象时，而且消耗大量内存是
 *          需要缓冲池的场景
 *
 * eg:String 常量池
 *    数据库连接池
 *
 * 注意：划分内部和外部状态，否则会引起线程安全
 *      享元类必须有一个工厂类加以控制
 */
public class PieceFactory {
    private HashMap<String,APiece> pieces=new HashMap<>();

    //获取享元类
    public APiece getPiece(String key){
        if (!pieces.containsKey(key)){
            APiece p=new OnePiece(key);
            pieces.put(key,p);
            return  p;
        }
        return pieces.get(key);
    }

    public int getPiecesCount(){
        return pieces.size();
    }
}
