package design_mode.mediator;

public class Client {
    public static void main(String[] args) {
        AChatRoom chatRoom=new ChatGroup();

        Member mem1,mem2,mem3,mem4;
        mem1=new VIPMember("杨毅");
        mem2=new VIPMember("马云");
        mem3=new CommonMember("袁世凯");
        mem4=new CommonMember("迪迦");

        chatRoom.register(mem1);
        chatRoom.register(mem2);
        chatRoom.register(mem3);
        chatRoom.register(mem4);

        mem1.sendText("马云","马云你好！！！");
        mem2.sendText("杨毅","杨毅你也好");
        mem3.sendText("杨毅","我是袁世凯，你好吗？");
        mem1.sendText("袁世凯","我挺好的，但是我要打你");
        mem4.sendImag("杨毅","这个图片不简单");
    }
}
