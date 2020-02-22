package homework_2.java;


public class FactoryRoleB extends FactoryRole {

    public Role creatRole(){
        return new RoleB();
    };
}
