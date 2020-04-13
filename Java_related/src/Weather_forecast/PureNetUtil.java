package Weather_forecast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class PureNetUtil {
	/**
     * get方法直接调用post方法
     * @param url 网络地址
     * @return 返回网络数据
     */
    public static String get(String url){
        return post(url,null);
    }
    /**
     * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
     * @param url 网络地址
     * @param param 请求参数键值对
     * @return 返回读取数据
     */
  public static String post(String url, Map<String, String> param) {
        HttpURLConnection conn = null;//连接的初始化
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();//打开连接
            StringBuffer sb = null;
            if (param != null) {// 如果请求参数不为空
                sb = new StringBuffer();
                /*
	                                          网址连接可用于输入和/或输出。
					如果您打算使用网址连接，请将标志设为true
					对于输出，如果不是，则为false。默认值为false。
                */
                // 默认为false,post方法需要写入参数,设定true
                conn.setDoOutput(true);
                // 设定post方法,默认get
                conn.setRequestMethod("POST");
                // 获得输出流
                OutputStream out = conn.getOutputStream();
                // 对输出流封装成高级输出流
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                // 将参数封装成键值对的形式，封装Map集合中的一组键值(key和value)
                //Map.Entry<String, String>为键值对的集合，封装了键值对
                for (Map.Entry<String, String> s : param.entrySet()) {
                    sb.append(s.getKey()).append("=").append(s.getValue()).append("&");//？？？？？？
                }
                // 将参数通过输出流写入，deleteCharAt(int index)删除字符串中指定位置的字符
                writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
                writer.close();// 一定要关闭,不然可能出现参数不全的错误
                sb = null;
            }
            conn.connect();// 建立连接
            sb = new StringBuffer();
            // 获取连接状态码
            int recode = conn.getResponseCode();
            BufferedReader reader = null;
            if (recode == 200) {//200     成功处理了请求，一般情况下都是返回此状态码
                // 从连接中获取输入流
                InputStream in = conn.getInputStream();
                // 对输入流进行封装
                reader = new BufferedReader(new InputStreamReader(in));
                String str = null;
                sb = new StringBuffer();
                // 从输入流中读取数据
                while ((str = reader.readLine()) != null) {
                	/*
                	不同系统中采用的换行符有所不同，所以使用System.getProperty(“line.separator”);
                	可以换取当前系统的换行符，避免因为linux或Windows或Mac系统的不同导致运行报错
                	一次代替固定格式的换行符
                    */
                	sb.append(str).append(System.getProperty("line.separator"));
                }
                // 关闭输入流
                reader.close();
                if (sb.toString().length() == 0) {
                    return null;
                }
                //截取第0到去除换行后的最后一个字符的字符串
                return sb.toString().substring(0,
                        sb.toString().length() - System.getProperty("line.separator").length());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null)// 关闭连接
                conn.disconnect();
        }
        return null;
    }
}
