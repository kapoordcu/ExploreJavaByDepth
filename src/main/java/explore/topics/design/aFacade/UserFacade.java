package explore.topics.design.aFacade;

public class UserFacade {
    public static void main(String[] args) {
        System.out.println("WITHOUT FACADE");
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        ReadWriteUser readWriteUser = new ReadWriteUser();
        ExecutableUser executableUser = new ExecutableUser();

        readOnlyUser.createUser();
        readWriteUser.createUser();
        executableUser.createUser();

        System.out.println("WITH FACADE");
        Facade facade = new Facade();
        facade.createUser(TYPE.READONLY);
        facade.createUser(TYPE.READWRITE);
        facade.createUser(TYPE.EXECUTABLE);
    }
}


enum TYPE {
    READONLY, READWRITE, EXECUTABLE
}

class Facade {
    public String createUser(TYPE type) {
        String user = new ReadOnlyUser().createUser();
        if(type==TYPE.READWRITE) {
            user = new ReadWriteUser().createUser();
        } else if(type==TYPE.EXECUTABLE) {
            user = new ExecutableUser().createUser();
        }
        return user;
    }
}


class ReadOnlyUser {
    public String createUser() {
        return "ReadOnlyUser department"; // 500 Lines
    }
}

class ReadWriteUser {
    public String createUser() {
        return "ReadWriteUser department";// 300 Lines
    }
}

class ExecutableUser {
    public String createUser() {
        return "ExecutableUser department";// 600 Lines
    }
}