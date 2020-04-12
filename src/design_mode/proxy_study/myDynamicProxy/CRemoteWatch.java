package design_mode.proxy_study.myDynamicProxy;

public class CRemoteWatch implements IWatchTV {
    @Override
    public void watchTv(String tvName) {
        for (int i=5;i>=0;i--){
            System.out.println(tvName+"动漫还有"+i+"秒播出");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tvName+"动漫开始播放了");
    }
}
