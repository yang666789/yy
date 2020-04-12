package design_mode.template_study;

public class Main {
    public static void main(String[] args) {
        ADefiniteIntegral[] template=new ADefiniteIntegral[2];
        template[0]=new DefiniteIntegral_x(0,20,10000);
        template[1]=new DefiniteIntegral_logx(2.71,7.344,10000);
        for (ADefiniteIntegral aDefiniteIntegral : template) {
            System.out.println(aDefiniteIntegral.definiteIntegralTemplate());
        }

    }
}
