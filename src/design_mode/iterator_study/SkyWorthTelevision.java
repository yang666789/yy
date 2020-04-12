package design_mode.iterator_study;

public class SkyWorthTelevision implements Television {

    private Object[] objects={"CCTV1","CCTV2","CCTV3","CCTV4","CCTV5"};
    @Override
    public TvIterator creatIterator() {
        return new SkyWorthIterator();
    }

    //内部迭代器类可以遍历其中内容
    private class SkyWorthIterator implements TvIterator {
        private int currentIndex=0;

        @Override
        public void next() {
            if (currentIndex< objects.length){
                currentIndex++;
            }
        }

        @Override
        public void previous() {
            if (currentIndex>0){
                currentIndex--;
            }
        }

        @Override
        public void setChannel(int i) {
            currentIndex=i;
        }

        @Override
        public Object getCurrentChannel() {
            return objects[currentIndex];
        }

        @Override
        public boolean isLast() {
            return currentIndex==objects.length;
        }

        @Override
        public boolean isFirst() {
            return currentIndex==0;
        }
    }
}
