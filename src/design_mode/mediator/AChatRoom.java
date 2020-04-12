package design_mode.mediator;

/***
 * 抽象中介类
 * 用于各同事对象之间的交互
 */
public abstract class AChatRoom {
    public abstract void register(Member member);
    public abstract void sendText(String from,String to,String message);
    public abstract void sendImag(String from,String to,String message);
}
