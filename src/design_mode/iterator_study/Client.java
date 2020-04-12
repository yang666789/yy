package design_mode.iterator_study;

public class Client {

    public static void display(Television tv){
        TvIterator iterator=tv.creatIterator();
        System.out.println("电视频道：");
        while (!iterator.isLast()){
            System.out.println(iterator.getCurrentChannel());
            iterator.next();
        }
    }

    public static void main(String[] args) {
        SkyWorthTelevision tv=new SkyWorthTelevision();
        display(tv);
    }
}
