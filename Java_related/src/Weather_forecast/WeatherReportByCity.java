package Weather_forecast;

import java.util.Scanner;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
public class WeatherReportByCity {
	/**
     * 根据城市名获取
     * @param cityName
     * @return
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=fe2c89e35628bf21de5717f1abd8d7ef";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @param args
     * @return 
     */
    public static void GetTodayTemperatureByCity(String city) {
        String result=excute(city);
        String[]results=new String[6];
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            /*获取返回状态码*/
            result=obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if(result!=null&&result.equals("200")){
            	result=obj.getString("result");
	            //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
	            //***********温度***********
	            obj=JSONObject.fromObject(result);
	            results[0]=obj.getString("today");
	            obj=JSONObject.fromObject(results[0]);
	            results[0]=obj.getString("temperature");
	            System.out.println("温度："+results[0]);
	            //***********天气***********
	            obj=JSONObject.fromObject(result);
	            results[1]=obj.getString("today");
	            obj=JSONObject.fromObject(results[1]);
	            results[1]=obj.getString("weather");
	            System.out.println("天气："+results[1]);
	            //***********风度***********
	            obj=JSONObject.fromObject(result);
	            results[2]=obj.getString("today");
	            obj=JSONObject.fromObject(results[2]);
	            results[2]=obj.getString("wind");
	            System.out.println("风度："+results[2]);
	          //***********星期***********
	            obj=JSONObject.fromObject(result);
	            results[3]=obj.getString("today");
	            obj=JSONObject.fromObject(results[3]);
	            results[3]=obj.getString("week");
	            System.out.println("星期："+results[3]);
	          //***********日期***********
	            obj=JSONObject.fromObject(result);
	            results[4]=obj.getString("today");
	            obj=JSONObject.fromObject(results[4]);
	            results[4]=obj.getString("date_y");
	            System.out.println("日期："+results[4]);
	          //***********未来***********
	            obj=JSONObject.fromObject(result);
	            results[5]=obj.getString("future");
	            System.out.println("未来几天(json形式)："+results[5]);
	            
	            obj=JSONObject.fromObject(results[5]);
	            String xml = new XMLSerializer().write(obj);
	            System.out.println("未来几天(XML形式)："+xml);
            }
        }
    }
  
    public static void main(String[] args) {
    	//while(true){
	    	Scanner in=new Scanner(System.in);
	    	System.out.println("请输入城市：");
			String location=in.nextLine();
	        GetTodayTemperatureByCity(location);
    	//}
    }
}
