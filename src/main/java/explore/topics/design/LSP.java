//package explore.topics.design;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class LSP {
//
//
//    public static void main(String[] args) {
//       List<User> users = Arrays.asList(
//               new BIUser("mobile_01"),
//               new INWTUser("prod_02"),
//               new LoggedOutUser("unknown")
//       );
//       users.stream().forEach(member -> member.accessBets());
//    }
//}
//
//abstract class User {
//    private String userName;
//
//    public User(String userName) {
//        this.userName = userName;
//    }
//
//    public abstract void accessBets();
//
//    public abstract void getBalance();
//}
//
//class BIUser extends User {
//
//    public BIUser(String userName) {
//        super(userName);
//    }
//
//    @Override
//    public void accessBets() {
//        System.out.println("Bets for BI visible");
//    }
//
//
//    @Override
//    public void getBalance() {
//        System.out.println("BI data is tracked");
//    }
//}
//
//class INWTUser extends User {
//
//    public INWTUser(String userName) {
//        super(userName);
//    }
//
//    @Override
//    public void accessBets() {
//        System.out.println("Bets for INWT visible");
//    }
//
//
//    @Override
//    public void getBalance() {
//        System.out.println("INWT data is tracked");
//    }
//}
//
//class LoggedOutUser extends User {
//
//    public LoggedOutUser(String userName) {
//        super(userName);
//    }
//
//    @Override
//    public void accessBets() {
//        System.out.println("Bets for LoggedOut User visible");
//    }
//
//    @Override
//    public void getBalance() {
//        // should not have balance, since not logged in, not beling able to substitute the parent class
//        // LoggedOutUser cannot have a balance, Its not a user
//    }
//}