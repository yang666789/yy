package Drawing_1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
 
import javax.swing.JButton;
import javax.swing.JFrame;
public class DramFrame extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		DramFrame dm = new DramFrame();
		dm.initUI();
	}
 
	/**
	 * 自定义初始化界面的方法
	 */
	public void initUI() {
		this.setTitle("画图程序");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setLayout(new FlowLayout());
 
		//2.实例化DrawListener事件处理类的对象，对象名dl。
		DrawListener dl = new DrawListener(this);
		
		// 定义数组，用来存储按钮上要显示的文字信息
		String[] typeArray = { "直线", "矩形", "圆" ,"三角形","长方体","图片"};
		// 循环遍历typeArray数组，根据数组中的数据创建按钮对象，将按钮对象添加到窗体上
		for (int i = 0; i < typeArray.length; i++) {
			JButton button = new JButton(typeArray[i]);
			this.add(button);
			
			//3.给事件源对象按钮添加addActionListener()动作监听方法，指定事件处理类的对象dl。
			button.addActionListener(dl);
			
		}
 
		// 定义数组，用来存储按钮上要显示的颜色信息
		Color[] colorArray = { Color.black,Color.RED,Color.green,new Color(255,255,255) };
		//循环遍历colorArray数组，根据数组中的数据创建按钮对象，将按钮对象添加到窗体上
		for (int i = 0; i < colorArray.length; i++) {
			JButton button = new JButton();
			button.setBackground(colorArray[i]);
			button.setPreferredSize(new Dimension(30,30));
			this.add(button);
 
			//3.给事件源对象按钮添加addActionListener()动作监听方法，指定事件处理类的对象dl。
			button.addActionListener(dl);
		}
 
		this.setVisible(true);
		
		//3.给事件源对象窗体添加addMouseListener()鼠标动作监听方法，指定事件处理类的对象dl。
		this.addMouseListener(dl);
	}
 
}

