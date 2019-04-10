package explore.topics.jvm;
/*

Platform Independence  = Hardware Architecture AND Operating System
One way to achieve PI via Interpreter,  We need to install interpreter specific to the platform, but its slow compared to executing compiled code.

Compilation : fast execution speed, NO PI
Interpreter : slow execution, PI

Java = C + I

Source Code -> COMPILER --> Byte code(PI) --> Result

SPEED ??
    Java Bytecode is compact(), compiled(syntax and semantics check already done) and optimized
    JIT compilation
    Java Bytecode is compactness  -> quick transfer across network
*/

public class JVMApp {
    public static void main(String[] args) {

    }


}
/*
    JVM = Corner stone of Java platform
    Why Virtual = Abstract computing Machine
        Instruction Set (JVM = Bytecode, CPU = Machine code)
        Manipulates memory at run time
    Core responsibility
        Automatic memory management
        Loading and Interpreting bytecode
        Security
    Specification and Implementation
        JVM specs (Blue Print of house)
        JLS = Java Language Specs
        Concrete implementation of JVM specs = Oracle's Hot spot jvm, IBM's jvm (actual House)
        Runtime Instance (When you run a java program , a jvm instance is created and loaded into memonry, JVM then loads the program into memory and executes) - Runs only 1 java application
    Performance
        Java Bytecode is compact, compiled(syntax and semantics check already done) and optimized
        JIT compilation  ---> Dynamic Compilation (Not defined in JVM specs, nut in concrete implementation)
            hot spots= identify frequently executed bytecode  ----> JIT compiler converts these hot spots to machine code and cache machine code FEB(frequently executed bytecode)
            Cached Machine codes are directly executed and not interpreted every single time .

       A method runs 1000 time, Optimized Machine code

*/
/*
    java Hello -> compiled into .class (jvm instance is launched) -> JVM invokes a sub component class loader --> unloads the bytecode into memory -> verified by Bytecode verifier
    --> Execution Engline (JIT Compiler + Interpreter)

    Garbage Collector = Automatic  Memory Management (Core resp of JVM)
    Security Manager = Can be used to allow the user to run untrusted bytecode, restrict any downloaded bytecode in access file system
    Run Time Data Area = Part of Memory (JVM starts, it gets a chunk of memory from OS )

*/
