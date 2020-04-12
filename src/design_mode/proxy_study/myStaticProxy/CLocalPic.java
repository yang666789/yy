package design_mode.proxy_study.myStaticProxy;

public class CLocalPic implements IShowPic,Runnable{
    @Override
    public void run() {
        pic.showPic(picname);
        System.out.println(picname+"图片加载完成");
    }

    private IShowPic pic;
    private String picname;
    @Override
    public void showPic(String picname) {
        pic=new CRemoPic();
        this.picname=picname;
        System.out.println("准备加载图片"+picname);
        Thread thread=new Thread(this);
        thread.start();
    }
}
