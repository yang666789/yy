package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID=1;
	private String name="simple";
	public String getName() {
		return name;
	}
}

class Teacher extends Person implements Serializable{
	private static final long serialVersionUID=1;
	private String name="yy";
	public String getName() {
		return name;
	}
}

class SerializeTool{
	public static void serialize(Object object,String fileName)throws Exception{
		File file=new File(fileName);//新建一个本地文件，用于存储序列化的对象字节流
		FileOutputStream output=new FileOutputStream(file);//文件输出流
		ObjectOutputStream oos=new ObjectOutputStream(output);//对象输出流
		oos.writeObject(object);//将对象写入对象输出流中
		oos.flush();//提交对象输入流
		oos.close();
		output.close();
	}
	
	public static Object deSerialize(String fileName)throws Exception {
		File file=new File(fileName);
		FileInputStream input=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(input);
		Object object=ois.readObject();
		ois.close();
		input.close();
		return object;
	}
	
	public static void printFileInfo(String fileName) {
		File file=new File(fileName);
		//System.out.println("------------------------");
		System.out.println("<文件名字>:"+fileName);
		System.out.println("<文件大小>:"+file.length()+" bytes");
		//System.out.println("------------------------");
	}
	
}

class SerializeTest{
	public static void main(String[] args)throws Exception {
		System.out.println("----------开始序列化人类（父类）----------");
		Person p=new Person();
		SerializeTool.serialize(p, "person.txt");
		SerializeTool.printFileInfo("person.txt");
		Object object=SerializeTool.deSerialize("person.txt");
		Person p1=(Person)object;
		System.out.println("----------开始序列化老师（子类）----------");
		Teacher t=new Teacher();
		SerializeTool.serialize(t, "teacher.txt");
		SerializeTool.printFileInfo("teacher.txt");
		object=SerializeTool.deSerialize("teacher.txt");
		Teacher t1=(Teacher)object;
		System.out.println("人类（父类）名字："+p1.getName());
		System.out.println("老师（子类）名字："+t1.getName());
		
	}
}










