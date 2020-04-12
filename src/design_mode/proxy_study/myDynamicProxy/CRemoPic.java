package design_mode.proxy_study.myDynamicProxy;

public class CRemoPic implements IShowPic {
    @Override
    public void showPic(String picname) {
        System.out.println("准备载入图片"+picname);
        for (int i=0;i<3;i++){
            System.out.println(i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(picname+"图片加载完成");
    }
}
