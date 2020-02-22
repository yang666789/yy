package homework_3.java;

public class FactoryRoleB extends FactoryRole {

    public Role creatRole(){
        return new RoleB();
    };
}
