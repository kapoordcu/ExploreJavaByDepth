package explore.topics.design.srp;

/*
This principle states that if we have 2 reasons to change for a class, we have to split the functionality in two classes.
Each class will handle only one responsibility and if in the future we need to make one change we are going to make it in the class which handles it.
*/

public class SRPSolved {
}

class UserValueSRP {
    private String uuid;
    public String userName;
    public Email emailId;

    public UserValueSRP(String uuid, String userName, Email emailId) {
        this.uuid = uuid;
        this.userName = userName;
        this.emailId = emailId;
    }

    public void greetMessage() {
        System.out.println("Welcom " + userName);
    }
}

class Email {
    private String emailId;

    public Email(String emailId) {
        this.emailId = emailId;
    }

    private boolean validateEmail(String emailId) {
        // eMail Check logic
        return true;
    }
}