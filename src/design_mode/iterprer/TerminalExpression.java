package design_mode.iterprer;

//终结符，相当于树中的叶子节点 eg.4+5+6，每个数相当于一个终结符，+-相当于非终结符
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean intepret(String context) {
        if (context.contains(data))
            return true;
        return false;
    }
}
