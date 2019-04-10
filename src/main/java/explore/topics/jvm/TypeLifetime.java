package explore.topics.jvm;

public class TypeLifetime {
    static {
        System.out.println("static initializer block : MAIN CLASS");
    }

    {
        System.out.println("instance initializer block : MAIN CLASS");
    }
    public static void main(String[] args) {
        System.out.println("Sub.STATIC_FINAL: " + Sub.STATIC_FINAL);
        System.out.println("Sub.STATIC_FINAL2: " + Sub.STATIC_FINAL2);
        new Sub();
    }
}

class Super {
    public Super() {
        System.out.println("Super class cons()");
    }
}

class Sub extends Super {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = (int) (Math.random()*5);
    {
        System.out.println("instance initializer block : SUB CLASS");
    }
    static {
        System.out.println("static initializer block : SUB CLASS");
    }
    public Sub() {
        System.out.println("Sub class cons()");
    }
}
/*
    static initializer block : MAIN CLASS
    Sub.STATIC_FINAL: 47
    static initializer block : SUB CLASS
    Sub.STATIC_FINAL2: 1
    Super class cons()
    instance initializer block : SUB CLASS
    Sub class cons()
*/

// This class is being accessed very first time(run from command line, being accessed from some other class)
/*
LOADING
        ---1) JVM loads the class BY CLASS LOADER
            -- CLASS LOADER (it searches the classpath, once found, loads byte code into memory, and generates a class object(Meta information: classname, superclass, method info) as a output of loading
            -- Class object is only created ONLY ONCE, Subsequent are loaded from memory
            -- Output of Loading is the Class object
LINKING
    VERIFICATION by Bytecode Verifier
        ---2) Well Formed check ? (Why its done again ? --- No trust, may be compiled by hostile compiler, avoid malicious actions)
    PREPARATION
        ---3) Allocates space for any of the static variables, and initialize them with default values
        ---4) Allocates space for instance variable, and initialize with default values
    RESOLUTION ( OPTIONAL STEP, can also happen after INITIALIZATION as well)
        ---5) Load reference classes (RUN TIME. Dynamic Linking)
INITIALIZATION
        ---6) Initialize variables with actual user defined values
                Super class will be loaded before the current class,
                If type happens to be interface , interface will be LOADED NOT initialized (only when static methods are accessed, Java 8 onwards)
*/
