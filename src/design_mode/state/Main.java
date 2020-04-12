package design_mode.state;

public class Main {
    public static void main(String[] args) {
        ThreadContext context=new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
    }
}
