package design_mode.visitor_study;

public class Customer extends AVisitor {

    @Override
    void visit(Apple apple) {
        System.out.println("顾客"+name+"选苹果");
    }

    @Override
    void visit(Book book) {
        System.out.println("顾客"+name+"买书");
    }
}
