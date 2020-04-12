package design_mode.mediator;

import java.util.Hashtable;

/***
 * 具体中介者
 * 持有同事对象的引用，负责协调各同事对象的行为以完成协作
 * 必须依赖具体同事对象（不符合依赖倒置原则）
 */
public class ChatGroup extends AChatRoom {

    private Hashtable<String,Member> members=new Hashtable<>();

    @Override
    public void register(Member member) {
        if (!members.contains(member)){
            members.put(member.getName(),member);
            //中介和成员相互注册产生联系
            member.setChatRoom(this);
        }
    }

    @Override
    public void sendText(String from, String to, String message) {
        Member member=(Member) members.get(to);
        String newMsg=message;
        newMsg=newMsg.replaceAll("打","*");
        member.receiveText(from,newMsg);
    }

    @Override
    public void sendImag(String from, String to, String image) {
        Member member=(Member) members.get(to);
        if (image.length()>5){
            System.out.println("图片太大，发送失败");
        }else {
            member.receiveImag(from,image);
        }
    }
}
