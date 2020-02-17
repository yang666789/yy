public class Client {

    public static void main(String[] args) throws Exception {
        FactoryRole factory=(FactoryRole) xmlUtil.getBean();
        Role role=factory.creatRole();
        role.play();
    }
}
