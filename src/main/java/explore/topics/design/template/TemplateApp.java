package explore.topics.design.template;

/*
Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
        TemplateMethod lets subclasses redefine certain steps of an algorithm without changing the
        algorithm’s structure.
It makes it easier to implement complex algorithms by encapsulating logic in a single method.
Developers often use it to provide framework users with a simple means of extending standard
functionality using inheritance.

Here are some examples of Template Methods in core Java libraries:

All non-abstract methods of java.io.InputStream, java.io.OutputStream,  java.io.Reader and java.io.Writer.

All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and  java.util.AbstractMap.

javax.servlet.http.HttpServlet, all the doXXX() methods by default send a HTTP 405 “Method Not Allowed” error as a response. You’re free to override any of them.

*/
// https://refactoring.guru/design-patterns/template-method/java/example
//
import java.io.InputStream;
import java.util.AbstractList;

public class TemplateApp {
    public static void main(String[] args) {
        InputStream inputStream;
        AbstractList abstractList;
    }
}
