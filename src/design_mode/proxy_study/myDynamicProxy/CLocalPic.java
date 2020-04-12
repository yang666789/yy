package design_mode.proxy_study.myDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * 动态代理类，增加被代理类时不用修改此代码
 */
public class CLocalPic {
    private Object target;
    public CLocalPic(Object target){
        this.target=target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        Thread thread=new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    method.invoke(target,objects);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        thread.start();
                        return null;
                    }
                });
    }

}
