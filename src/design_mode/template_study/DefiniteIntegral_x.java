package design_mode.template_study;

public class DefiniteIntegral_x extends ADefiniteIntegral{

    double a,b;
    int c;

    public DefiniteIntegral_x(double a, double b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    protected double geta() {
        return a;
    }

    @Override
    protected double getb() {
        return b;
    }

    @Override
    protected int getc() {
        return c;
    }

    @Override
    protected double function(double x) {
        return x;
    }
}
