package design_mode.visitor_study;


public class Saler extends AVisitor {

    @Override
    void visit(Apple apple) {
        System.out.println("收银员"+name+"称斤结算苹果价钱");
    }

    @Override
    void visit(Book book) {
        System.out.println("收银员"+name+"直接算书的价格");
    }
}
