package design_mode.iterprer;

/***
 * 根据固定文法构建一个解释句子的解释器
 * 优点：可扩展性好，灵活
 * 缺点：实现场景少
*       对复杂文法较难维护
 *      采用递归调用模式
 */
public class Client {

    public static void main(String[] args) {
        Expression isMale=getMaleExpression();
        Expression isMarried=getMarriedExpression();
        System.out.println("John is a male?"+
                isMale.intepret("John"));
        System.out.println("Julie is a married woman?"+
                isMarried.intepret("Married Julie"));
    }

    public static Expression getMaleExpression(){
        Expression robert=new TerminalExpression("Robert");
        Expression john=new TerminalExpression("John");
        return new OrExpression(robert,john);
    }

    public static Expression getMarriedExpression(){
        Expression julie=new TerminalExpression("Julie");
        Expression married=new TerminalExpression("Married");
        return new AndExpression(julie,married);
    }
}
