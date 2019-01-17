package explore.topics.design;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SRP {
    public static void main(String[] args) throws Exception {
        EventValue j = new EventValue();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        j.addEntry("I hate my life");
        System.out.println(j);

        Persistence persistence = new Persistence();
        String fileName = "journal.txt";
        persistence.saveToFile(j, fileName, true);
    }
}

class EventValue {
    private final List<String> eventList = new ArrayList<>();

    private static int count = 0;

    public void addEntry(String eventId)  {
        eventList.add("" + (++count) + ": " + eventId);
    }

    public void removeEntry(int index) {
        eventList.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), eventList);
    }

    // Break SRP, Persistence is different concern
    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }

    public void load(String fileName) {

    }

    public void load(URL url) {

    }
}

class Persistence {
    public void saveToFile(EventValue eventValue,
                           String filename,
                           boolean overwrite) throws Exception {
        if(overwrite || new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(eventValue.toString());
            }
        }
    }
}