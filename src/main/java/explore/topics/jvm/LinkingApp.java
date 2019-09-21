package explore.topics.jvm;
/*
LINKING
        VERIFICATION by Bytecode Verifier
        ---1) Well Formed check ? (Why its done again ? --- No trust, may be compiled by hostile compiler, avoid malicious actions)
        ---2) conformity with java language rules, Class file might have been loaded from across the n/w(hostile compiler) or from local file system

            Bytecode Verifier --> safe or exception
            Examples
                final class are not sub-classed
                final methods are not overridden
                No illegal method overloading
                byte code integrity

        PREPARATION
        ---3) Allocates space for any of the static variables, and initialize them with default values -- OutOfMemory in case no space
        ---4) Allocates space for instance variable, and initialize with default values (after static fields are initialized)


        RESOLUTION (it is an OPTIONAL STEP, can also happen after INITIALIZATION as well)
        ---5) Load reference classes (RUN TIME. Dynamic Linking)  --> symbolic references and loads them
                Logical References ==  symbolic references
                Stored in a one area of .class file of constant pool (can also include compile time constants and string literals)
                At run time that are replaced with direct references


                Resolution Check -> Permissions, Fields exists, correct type (Resolution also does some form of verification)
*/


/*

                Hello hello = new Hello()   ====   {source code )
                            |
                            |   After compilation
                            |
                            V
                 --------------------------------------------------------
                            new #2  (bytecode instruction)
                            ...
                            Constant Pool (like array)

                            #2 = Class #19  (index number 19)
symbolic reference-->       #19 = Utf8 Hello
                  --------------------------------------------------------

At runtime jvm creates an internal version of this constant pool which is refereed to as Runtime Constant pool
At resolution step the component doing resolution will look at symbolic reference within the constant pool, and would load the class hello(all 3 stages) and would be stored in the Heap
The symbolic reference will now be replaced with direct references to that Hello instance on the heap ---> RESOLVED ONLY ONCE, After that Direct ref are used

Dynamic Linking +- [+  easy updates, replace a class file with newer class ] [ stopped working with incompatible versions , in new class file a method is removed, JVM would generate an error ]
Approaches
    Eager Loading : resolution happens after preparation  [ loaded upfront ]
    Lazy Loading: after initialization (on demand)  -- TYPICALLY
 */
public class LinkingApp {
    public static void main(String[] args) {

    }
}
