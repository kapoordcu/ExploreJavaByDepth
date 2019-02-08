package explore.topics.design.srp;

public class SRPBroken {
    public static void main(String[] args) {

    }
}

// this class should not include email validation because that is not related with a person behaviour

// We can improve the class above by removing the responsibility of email validation from the Person
// class and creating a new Email class that will have that responsibility:

class UserValue {
    private String uuid;
    public String userName;
    public String emailId;

    public UserValue(String uuid, String userName, String emailId) {
        this.uuid = uuid;
        this.userName = userName;
        if(this.validateEmail(emailId)) {
            this.emailId = emailId;
        }
        else {
            throw new Error("Invalid email!");
        }
    }

    private boolean validateEmail(String emailId) {
        // eMail Check logic
        return true;
    }
    public void greetMessage() {
        System.out.println("Welcom " + userName);
    }
}

// this class should not include email validation because that is not related with a person behaviour: