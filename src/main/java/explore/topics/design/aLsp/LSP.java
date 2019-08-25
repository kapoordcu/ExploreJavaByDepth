package explore.topics.design.aLsp;

public class LSP {
    public static void main(String[] args) {
       User u1 = new SimpleUser("simple");
       User u2 = new AdminUser("admin");

       u1.accessCredentials();
       u2.accessCredentials();
    }
}

abstract class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public abstract void accessTables();

    public abstract void accessCredentials();
}

class SimpleUser extends User {

    public SimpleUser(String userName) {
        super(userName);
    }

    @Override
    public void accessTables() {
        System.out.println("Simple user access the tables.");
    }

    @Override
    public void accessCredentials() {
        throw new UnsupportedOperationException("Not an admin user");
        // should not be able to access credential, since not an admin,
        // not being able to substitute the parent class
    }

}

class AdminUser extends User {

    public AdminUser(String userName) {
        super(userName);
    }

    @Override
    public void accessTables() {
        System.out.println("Admin user access the tables.");
    }

    @Override
    public void accessCredentials() {
        System.out.println("user is admin");
    }
}