package homework_2.java;


public class FactoryRoleA extends FactoryRole {

    public Role creatRole(){
        return new RoleA();
    };
}
