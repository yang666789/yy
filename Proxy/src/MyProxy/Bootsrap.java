package MyProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//动态代理
public class Bootsrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person=new Person();
		Animal animal=new Animal();
		Speakable speakable=(Speakable)Proxy.newProxyInstance(Speakable
				.class.getClassLoader(),new Class[]{Speakable.class}, new MyProxy(person));
		speakable.speak();
	    speakable=(Speakable)Proxy.newProxyInstance(Speakable
				.class.getClassLoader(),new Class[]{Speakable.class}, new MyProxy(animal));
		speakable.speak();
		}
	}

interface Speakable{
	public void speak();
}

class Person implements Speakable{
	@Override
	public void speak() {
		System.out.println("我是人类 ");
		
	}
}

class Animal implements Speakable{
	@Override
	public void speak() {
		System.out.println("我是动物 ");
	}
}

class MyProxy implements InvocationHandler {
	private Object proxied;
	public MyProxy(Object proxied) {
		this.proxied=proxied;
	}
	@Override
	public Object invoke(Object proxy,Method method,Object[]args)throws Throwable{
		method.invoke(this.proxied,args);
		System.out.println("运行时间："+System.currentTimeMillis());
		return null;
	}
	
}
