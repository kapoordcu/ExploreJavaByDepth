package explore.topics.jvm;

/*
LOADING
    If (class object on heap) {
     --> return class object
    } else { // type is accessed very first time
          boolean foundType = findType [ tried to locate the .class file using parent delegation model
          if(foundType) {
            loads the bytecode and create Class Object and return it, saved in heap for future use
          } else {
            ClassNotFoundException
          }

    }


Parent Delegation model - Java has multiple class loaders each loading classes from different repository

                            Bootstrap(Primordial) ($java_home/jre/lib/rt.jar   --> all core java api classes, This is implemented as part of jvm

                                ^
                                |
                                |

                            Extension     $java_home/jre/lib/ext/*.jar   -------> standard java extension apis

                                ^
                                |
                                |

                            Application/System   $classpath   --> standard java extension apis, Application classes from CP

                                ^
                                |
                                |

                        user defined class loader   ---> custom class loaders, extend Abstract class Classloader (java.lang)

Parent-Child relationship -->  delegates the search responsibility to its parent. WHY -> The top repositories are more trustworthy  (no stringent security checks in the verification step in lining stage)
----------------------------------------------------
CLASS LOADED FIRST TIME
    ---1) new instance is create (if interface ---> not valid)
    ---2) invoking static method  (only Java8 for Interfaces)
    ---3) static fields access [reading, assigning]  (accessing compile time constants will not load the class)
    ---4) subclass is loaded  (for  interface if sub interface is loaded)
    ---5) Run from CMD line  (only Java8 for Interfaces)
    ---6) Reflection


CLASS OBJECT
    ---1) JVM uses Class object  to create a new instance
    ---2) Class ===  [ Class, Interface, Primitives, void, Arrays ] all have class object,  For array length does not matter.  int[3] and int[30] will have same class object

meta-information
        public String getName();           name of the class
        Class<? super T> getSuperclass();  superclass of the current class, if object/interface/primitive/void ---> null, for Array -> Object is returned
        public native boolean isInterface();
        Class<?>[] getInterfaces()   [ all the interfaces ]
        static ClassLoader getClassLoader(Class<?> caller);

 */
public class ClassLoadingApp {

}
