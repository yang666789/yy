package design_mode.visitor_study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyCar {

    private List<IProduct> list=new ArrayList<>();

    //结账操作
    public void accept(AVisitor visitor){
        Iterator<IProduct> iterator=list.iterator();
        while (iterator.hasNext()){
            iterator.next().accept(visitor);
        }
    }

    public void addProduct(IProduct product){
        list.add(product);
    }

    public void removeProduct(IProduct product){
        list.remove(product);
    }
}
