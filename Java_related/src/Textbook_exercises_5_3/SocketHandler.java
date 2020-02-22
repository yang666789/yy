package Textbook_exercises_5_3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class SocketHandler implements Runnable {
	private Socket socket;
	Scanner input=new Scanner(System.in);
	public SocketHandler(Socket socket){
		this.socket = socket;		
	}
	@SuppressWarnings("unchecked")
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader buffer_reader=new BufferedReader(reader);
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			String client = "<" + socket.getInetAddress().toString() + " : " + socket.getPort() + ">";
			boolean f=true;
			while(f){
				String request = buffer_reader.readLine();
				//注册（判断字符串是否以此参数字符串开头）
				if(request.startsWith("<register "))
				{ 
					String name="";
					for(int i=0;i<request.length();i++){//两个循环扫描得到引号里的用户名
						if(request.charAt(i)=='”'){
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='”'){
								   i=j+1;
								   break;	
								}
								name=name+String.valueOf(request.charAt(j));
							}
							break;
						}
					}
					//要先注册才能把用户的名字存储到哈希表中
					Server.users.put(name, writer);//将用户名存储写入图中
					
					if(name.equals("")){
					    writer.println("<result 失败>");
					}else{
						writer.println("<result 注册成功！>");
					}		
				}
				//登录
				else if(request.startsWith("<login "))
				{
					String userName="";
					for(int i=0;i<request.length();i++){//得到用户名
						if(request.charAt(i)=='”'){
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='”'){
								   i=j+1;
								   break;	
								}
								userName=userName+String.valueOf(request.charAt(j));
							}
							break;
						}
					}
					if(userName.equals("")){
					    writer.println("<result 失败>");
					}else{
						writer.println("<result 登录成功！>");
					}		
				}
				//发消息
				else if(request.startsWith("<message")) //用于转发 信息message from="xu" to="zhang" message="ddd" />
				{
					int count=0;//计数器，记录引号的数量  
					String toName="";//得到收件人的名字
					String message="";//得到发送的信息
					//得到Message里面的内容
					for(int i=0;i<request.length();i++){//发过来的消息中一共有6个引号（“）
						if(request.charAt(i)=='”'){
							count++;
							if(count==3){//从第3个引号开始扫描得到另一客户端的名字直到第4个引号
								for(int j=i+1;j<request.length();j++){
									if(request.charAt(j)=='”'){
									   count++;
									   i=j+1;
									   break;	
									}
									toName=toName+String.valueOf(request.charAt(j));//收件人的名字
								}
							}
							if(count==5){//扫描第五到第六个引号之间的内容得到发送到另一客户端的信息
								for(int j=i+1;j<request.length();j++){
									if(request.charAt(j)=='”'){
									   i=j+1;
									   break;	
									}
									
									message=message+String.valueOf(request.charAt(j));//得到信息内容
									
								}
								break;
							}						
						}
					}
					//建立一个新的输出流对象，该对象存储的是接收消息的人
					PrintWriter toWriter =  Server.users.get(toName); 

					if(toWriter!=null){				
						toWriter.println(message);//向另一客户端写入信息
						toWriter.flush();
					}else{
						writer.println("对不起！没有此用户！请检查......");
					}				
				} 
				//退出
				else if(request.startsWith("<logout"))//退出登录//<logout from ="xu" />
				{
					String name="";
					for(int i=0;i<request.length();i++){//得到用户名
						if(request.charAt(i)=='”'){
							for(int j=i+1;j<request.length();j++){
								if(request.charAt(j)=='”'){
								   i=j+1;
								   break;	
								}
								name=name+String.valueOf(request.charAt(j));
							}
							break;
					     }
			          }
					Server.users.remove(name);//删除用户名
					
					writer.println("<result 退出成功！>");
					break;
				}else if(request.equals("update")){
					
				}else{
					writer.println("输入有误！请重新输入");
				}
				
				writer.flush();
			}
			
			writer.close();
			buffer_reader.close();
			socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public static void FileInformation(String texts){//显示收到的文本
		JFrame showInfo=new JFrame();
		JPanel jp=new JPanel();
		JTextArea text=new JTextArea(20,20);//文本区
		text.append(texts+"\n");//输入
		jp.add(text);
		showInfo.add(jp);
		
		showInfo.setTitle("服务端相应！");
		showInfo.setVisible(true);
		showInfo.setSize(300,200);
		showInfo.setLocation(500, 500);
		showInfo.setDefaultCloseOperation(1);
	}
	}