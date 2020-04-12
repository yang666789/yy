package design_mode.visitor_study;

public class Apple implements IProduct{

    @Override
    public void accept(AVisitor visitor) {
        visitor.visit(this);
    }
}
