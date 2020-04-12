package design_mode.iterator_study;

public interface TvIterator {
    void next();
    void previous();
    void setChannel(int i);
    Object getCurrentChannel();
    boolean isLast();
    boolean isFirst();
}
