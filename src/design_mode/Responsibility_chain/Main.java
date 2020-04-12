package design_mode.Responsibility_chain;

import design_mode.Responsibility_chain.concreteFruitSort.BigFruitSort;
import design_mode.Responsibility_chain.concreteFruitSort.MiddleFruitSort;
import design_mode.Responsibility_chain.concreteFruitSort.SmallFruitSort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        AbstractFruitSort bfs,mfs,sfs;
        bfs=new BigFruitSort(9);
        mfs=new MiddleFruitSort(5);
        sfs=new SmallFruitSort(2);

        //构成真正的水果链
        bfs.setNextFruitSort(mfs);
        mfs.setNextFruitSort(sfs);

        Random rd=new Random();
        for (int i=0;i<1000;i++){
            //生成0-9的随机数
            int weight=rd.nextInt(10);
            //将水果放在职责链链首
            bfs.pushFruit(weight,"西瓜");
        }
        //显示每个过滤器里的水果
        bfs.getFruit();
        mfs.getFruit();
        sfs.getFruit();
    }
}
