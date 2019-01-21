package explore.topics.design;

import java.util.Arrays;
import java.util.List;

public class LSPSolved {


    public static void main(String[] args) {
        List<IaccessBets> users = Arrays.asList(
                new BIUser("mobile_01"),
                new INWTUser("prod_02"),
                new LoggedOutUser("unknown")
        );
        users.stream().forEach(member -> member.accessBets());
    }
}

interface IsystemUser {
    void getBalance();
}

interface IaccessBets {
    void accessBets();
}

abstract class User implements IsystemUser, IaccessBets {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public abstract void accessBets();

    public abstract void getBalance();
}

class BIUser extends User {

    public BIUser(String userName) {
        super(userName);
    }

    @Override
    public void accessBets() {
        System.out.println("Bets for BI visible");
    }


    @Override
    public void getBalance() {
        System.out.println("BI data is tracked");
    }
}

class INWTUser extends User {

    public INWTUser(String userName) {
        super(userName);
    }

    @Override
    public void accessBets() {
        System.out.println("Bets for INWT visible");
    }


    @Override
    public void getBalance() {
        System.out.println("INWT data is tracked");
    }
}

class LoggedOutUser implements IaccessBets {
    private String userName;

    public LoggedOutUser(String userName) {
        this.userName=userName;
    }
    @Override
    public void accessBets() {
        System.out.println("Bets for LoggedOut User visible: "+userName);
    }

}