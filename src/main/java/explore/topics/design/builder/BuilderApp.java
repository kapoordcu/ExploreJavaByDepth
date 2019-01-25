package explore.topics.design.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderApp {
    public static void main(String[] args) {

        String[] words = {"Hello", "World"} ;
        // Build up the objects piece by piece
        StringBuilder builder = new StringBuilder();
        builder.append("<ul>\n");
        for (String word: words) {
            builder.append(String.format("  <li>%s</li>\n", word));
        }
        builder.append("</ul>");
        System.out.println(builder);
    }


    class HtmlElement {
        public String name, text;
        public List<HtmlElement> elements = new ArrayList<HtmlElement>();
        private final int indentSize = 2;
        private final String newLine = System.lineSeparator();

        public HtmlElement() {}

        public HtmlElement(String name, String text) {
            this.name = name;
            this.text = text;
        }

        private String toStringImpl(int indent) {
            return "";
        }

    }
}
