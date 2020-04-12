package design_mode.iterprer;

//非终结符
public class AndExpression implements Expression {

    private Expression exp1=null;
    private Expression exp2=null;

    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public boolean intepret(String context) {
        return exp1.intepret(context) && exp2.intepret(context);
    }
}
