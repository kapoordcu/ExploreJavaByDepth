package explore.topics.design.aOCP.voilate;


public class BookVoilate {
}

enum BookName {
    Text, PDF, XML, JSON
}
interface Book {
    BookName findBook();

}

interface NewBook extends Book { // you'd be working conform the Interface Segregation principle.
    String printName();
}

class SoftwareBook implements NewBook {

    @Override
    public BookName findBook() {
        // New req: print the name of the book....Can I print here using sout ? you'd be violating the Single Responsibility Principle , ONLY Find, NOT print
      /*  if all your Book implementors require to print the name,
      you'd add that to your interface.
      By doing so you extend the functionality, but you do not change the existing functionality.
      e.g.: Every part of the system that was expecting to find a book and not printing it, still will just find a book and not printing it.
                */
        return BookName.Text;
    }

    @Override
    public String printName() {
        return BookName.JSON.name();
    }
}