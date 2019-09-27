package Drawing_1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
 
public class DrawListener implements ActionListener, MouseListener {
	private String type = "直线";// 存储图形的属性
	private Color color = Color.BLACK;// 存储颜色的属性
	private int x1, y1, x2, y2;// 存储按下释放坐标值的属性
	private Graphics g;// 声明Graphics的画笔对象属性，你要在哪一个组件上画图形，那画笔就从这个组件上获取
	private DramFrame dm;// 声明画图窗体对象属性
 
	
	public DrawListener(DramFrame dm) {
		this.dm = dm;
	}
 
	/**
	 * 重写接口的抽象方法，也是发生事件后的处理方法
	 * 
	 * @param e对象中存储事件源对象相关信息和动作信息。
	 */
	public void actionPerformed(ActionEvent e) {
		// 获取事件源对象
		JButton button = (JButton) e.getSource();
 
		// 1.1.判断点击的是否是颜色按钮，如果是则获取按钮上的背景颜色存储起来。
		if (button.getText().equals("")) {
			color = button.getBackground();// 获取按钮上的背景颜色
			System.out.println(color);
		}
		// 1.2.判断点击的是否是图形按钮，如果是则获取按钮上的图形存储起来。
		else {
			type = button.getText();// 获取按钮上的文字
			System.out.println(type);
		}
	}
 
	//测试鼠标点击
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
	}
 
   //记录鼠标按下时的坐标
	public void mousePressed(MouseEvent e) {
		System.out.println("按下");  //测试鼠标按下
		x1 = e.getX();
		y1 = e.getY();
 
		// 获取窗体上的画笔对象
		g = dm.getGraphics();// 注意：获取组件上的画笔时，一定要在窗体可见之后获取，否则获取的是null。
		g.setColor(color);// 设置画笔的颜色
	}
 
	//鼠标松开时记录坐标并画图
	public void mouseReleased(MouseEvent e) {
		System.out.println("释放");
		// 1.4.获取鼠标释放时的坐标值，要存储释放的坐标值
		x2 = e.getX();
		y2 = e.getY();
		// 1.5.使用画笔对象，根据按下和释放的坐标值来绘制图形
		if(type.equals("直线"))
			g.drawLine(x1, y1, x2, y2);
		if(type.equals("矩形"))
			g.drawRect(x1,y1,x2-x1,y2-y1);
		if(type.equals("圆"))
			g.drawOval(x1,y1,x2-x1,y2-y1);
		if(type.equals("三角形"))
			{ int[] xPoints = new int[] { x1, Math.abs((x1 + x2) / 2), x2 };
	        int[] yPoints = new int[] { y2, y1, y2 };
	        int nPoints = 3;
	        g.drawPolygon(xPoints, yPoints, nPoints);
			}
		if(type.equals("长方体"))
		{int a=(x2+y2-x1-y2)/2;
		 g.drawRect(x1, y1, x2-x1,y2-y1);
		 g.drawLine(x1, y1, x1+a, y1-a);
		 g.drawLine(x1+a, y1-a,x2+a, y1-a);
		 g.drawLine(x2, y1, x2+a,y1-a);
		 g.drawLine(x2, y2, x2+a, y2-a);
		 g.drawLine(x2+a,y1-a,x2+a,y2-a);
			
		}
			}
	//测试鼠标进入窗口
	public void mouseEntered(MouseEvent e) {
		System.out.println("进入");
	}
  //测试鼠标退出窗口
	public void mouseExited(MouseEvent e) {
		System.out.println("退出");
	}
}
