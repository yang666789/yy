package design_mode.mediator;

public class VIPMember extends Member {

    public VIPMember(String name){
        super(name);
    }

    @Override
    public void sendText(String to, String message) {
        System.out.println("会员发送消息：");
        chatRoom.sendText(name,to,message);
    }

    @Override
    public void sendImag(String to, String image) {
        System.out.println("会员发送图片:");
        chatRoom.sendImag(name,to,image);
    }
}
