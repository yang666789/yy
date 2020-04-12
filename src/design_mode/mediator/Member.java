package design_mode.mediator;

/***
 * 非常符合迪米特法则，不和陌生人讲话
 * 抽象同事角色
 * 同事间通信时，通过中介协调者完成
 * 每个同事对象有两种行为：
 *      a.自发行为：发消息，在具体同事类里实现
 *      b.依赖方法：接收消息，是被动行为，发了之后才被动接收，在同事抽象类中实现
 *
 * 优点：对象彼此解耦，增加对象复用性
 *      控制逻辑集中，简化系统维护
 *      一对多变为一对一，便于理解
 * 缺点：中介者承担过多责任，会使程序变得复杂，并且不好维护
 *      出现一对多的情况时，不要急于使用此模式，应先反思系统设计是否合理
 */
public abstract class Member {
    public AChatRoom chatRoom;
    public String name;

    public Member(String name){
        this.name=name;
    }

    public abstract void sendText(String to,String message);
    public abstract void sendImag(String to,String image);

    public void receiveText(String from,String message){
        System.out.println(from+" 发送文本给 "+this.name+" 内容："+message);
    }

    public void receiveImag(String from,String message){
        System.out.println(from+" 发送图片给 "+this.name+" 内容："+message);
    }

    public String getName() {
        return name;
    }

    public void setChatRoom(AChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public AChatRoom getChatRoom() {
        return chatRoom;
    }
}
