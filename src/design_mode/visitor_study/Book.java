package design_mode.visitor_study;


public class Book implements IProduct {
    @Override
    public void accept(AVisitor visitor) {
        visitor.visit(this);
    }
}
