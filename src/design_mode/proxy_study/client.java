package design_mode.proxy_study;

import design_mode.proxy_study.myDynamicProxy.*;

public class client {
    public static void main(String[] args) {
        //静态代理
//        IShowPic pic=new CLocalPic();
//        pic.showPic("汉堡包");

        //动态代理
//        IShowPic pic=new CRemoPic();
//        CLocalPic cLocalPic=new CLocalPic(pic);
//        IShowPic pic1=(IShowPic) cLocalPic.getProxyInstance();
//        pic1.showPic("火影忍者");

        IWatchTV tv=new CRemoteWatch();
        CLocalPic myTV=new CLocalPic(tv);
        IWatchTV tv1=(IWatchTV) myTV.getProxyInstance();
        tv1.watchTv("名侦探柯南");
    }
}
