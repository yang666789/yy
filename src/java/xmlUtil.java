import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class xmlUtil {

    static Object getBean() throws Exception {
        //创建dom文档对象
        DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        Document doc;
        doc= builder.parse(new File("src/resource/Role.xml"));

        //获取包含类名的文本节点
        NodeList nodeList=doc.getElementsByTagName("className");
        Node node=nodeList.item(0).getFirstChild();
        String name=node.getNodeValue();

        //通过类名生成实例对象并返回
        Class clazz=Class.forName(name);
        Object object=clazz.newInstance();
        return object;
    }

}
