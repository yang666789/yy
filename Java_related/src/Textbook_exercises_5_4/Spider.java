package Textbook_exercises_5_4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider {
	public static void main(String[] args) {
		try {
			Spider spider=new Spider();
			//链接的时候设定超时时间为10秒，否则不设定可能会出现超时异常
	        Document html = Jsoup.connect("http://www.w3.org/Consortium/Member/List")
	        		.timeout(10000).get();
	        // 所有注释对应着网页查看（检查元素）
	        // 首先拿到类名为r的div里的所有数据
	        Elements div_content = html.select(".unit.size2on3");
	        // 然后拿到div中所有的li标签,就是相对应的所有的列表
	        Elements lis = div_content.select("li");
	        int li_number =lis.size();
	        System.out.println("CURRENT MEMBERS的个数："+li_number);
	        int i=1;
	        StringBuffer totalStr=new StringBuffer();
	        //totalStr="\r\n";
	        for (Element element : lis) {
//	        	获取属性class为member的元素
//	        	可lis中有一个成员DigiCert SSL Certificate Authority没有属性，
//	        	所以获取的时候只能到此，并且还会报空指针异常，所以一次性获取所有Li
//	        	Element ele  = element.
//	        			getElementsByAttributeValue("class","member").first();
	        	String member=element.text();
	        	System.out.println("CURRENT MEMBERS第"+i+"个成员为"+member);
	        	totalStr.append(member+"\r\n");
	        	i++;
	        }
	        String str=totalStr.toString();
	        spider.TextToFile("E:\\Textbook_exercises_5_4.txt",str );
		}
		catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
}
	}
	public void TextToFile(final String strFilename, final String strBuffer)
	  {
	    try
	    {    
	      // 创建文件对象
	      File fileText = new File(strFilename);
	      if(!fileText.exists()) {
	    	  System.out.println("文件不存在，正在新建文件，请到指定路径查看......");
	    	  fileText.createNewFile();
	      //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件,如果为 true，
	      //则将字节写入文件末尾处，而不是写入文件开始处
	      //(默认是false表示覆盖原本内容)
	      FileWriter fileWriter = new FileWriter(fileText,true);
	 
	      // 写文件      
	      fileWriter.write(strBuffer);
	      // 关闭
	      fileWriter.close();}
	      else {
	    	  System.out.println("当前目录文件存在");
	    	  //直接覆盖原文件内容
	    	  FileWriter fileWriter = new FileWriter(fileText);
	    		 
		      // 写文件      
		      fileWriter.write(strBuffer);
		      // 关闭
		      fileWriter.close();
	      }
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }

}
