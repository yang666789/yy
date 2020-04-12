package design_mode.template_study;

/***
 * 求定积分
 * 利用了模板方法模式
 * 其中抽象方法从子类中拉取过来，再来实现相关算法
 * 在程序运行时，具体子类的基本方法将覆盖父类的中定义的基本方法
 * 实现子类对父类的反向控制
 */
public abstract class ADefiniteIntegral {
    abstract protected double geta();//下限
    abstract protected double getb();//上限
    abstract protected int getc();//切分单元格
    abstract protected double function(double x);//被积函数

    public final double definiteIntegralTemplate(){
        double a,b,t,sum=0;
        int c;
        a=geta();b=getb();c=getc();
        if(a>b){
            t=a;a=b;b=t;
        }
        t=(b-a)/(double) c;
        for(int i=0;i<c;i++){
            sum+=t*function(a+i*t);
        }
        return sum;
    }


}
