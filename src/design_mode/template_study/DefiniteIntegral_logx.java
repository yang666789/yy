package design_mode.template_study;

public class DefiniteIntegral_logx extends ADefiniteIntegral {

    double a,b;
    int c;

    public DefiniteIntegral_logx(double a, double b, int c) {
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
        return Math.log(x);
    }
}
