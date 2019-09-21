package explore.topics.design.aLsp;

import java.util.ArrayList;
import java.util.List;

public class LSPSolved {
    public static void main(String[] args) {
        List<ReadOnlyAccess> users = new ArrayList<>();
        users.add(new SimpleUserV("mobile_01")         );
        users.add(new AdminUserV("mobile_01")         );

        users.stream().forEach(member -> member.accessTables());
    }
}

interface ReadOnlyAccess {
    void accessTables();
}

interface AdminAccess {
    void accessCredentials();
}

abstract class UserV implements ReadOnlyAccess, AdminAccess {
    private String userName;

    public UserV(String userName) {
        this.userName = userName;
    }

    public abstract void accessTables();

    public abstract void accessCredentials();
}

class AdminUserV extends UserV {

    public AdminUserV(String userName) {
        super(userName);
    }

    @Override
    public void accessTables() {
        System.out.println("Admin user access the tables.");
    }


    @Override
    public void accessCredentials() {
        System.out.println("Admin user access the credentials");
    }
}

class SimpleUserV implements ReadOnlyAccess {
    private String userName;

    public SimpleUserV(String userName) {
        this.userName=userName;
    }

    @Override
    public void accessTables() {
        System.out.println("Simple user access the tables.");
    }
}