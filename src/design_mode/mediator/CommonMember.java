package design_mode.mediator;

public class CommonMember extends Member {

    public CommonMember(String name){
        super(name);
    }

    @Override
    public void sendText(String to, String message) {
        System.out.println("普通会员发送消息:");
        //让中介帮忙发消息
        chatRoom.sendText(name,to,message);
    }

    @Override
    public void sendImag(String to, String image) {
        System.out.println("普通会员不能发送图片!!!");
    }
}
