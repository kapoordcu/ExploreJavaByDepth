package explore.topics._strings;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String sentence = "This is fucking boring place and I hate coming here everyday";
        reverseWords(sentence);
        String sentence2 = "This. is. fucking. boring. place. and. I. hate. coming. here. everyday.";
        System.out.println(reverseWordsWithoutIndividualReverse(sentence2));
        System.out.println(reverseWordsWithoutSplitFunction(sentence));
    }

    private static String reverseWordsWithoutSplitFunction(String sentence) {
        StringBuilder builder = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = sentence.length()-1; i >=0 ; i--) {
            char ch = sentence.charAt(i);
            if(Character.isWhitespace(ch)) {
               builder.append(reverseWord(word.toString()) + " ");
                word.setLength(0);
            } else {
                word.append(ch);
            }
        }
        builder.append(reverseWord(word.toString()) + " ");
        return builder.toString();
    }

    private static String reverseWordsWithoutIndividualReverse(String sentence) {
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split("\\.");
        for (int i = words.length-1; i >=0 ; i--) {
            builder.append(words[i].trim() + " ");
        }
        return builder.toString();
    }

    private static void reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            System.out.println(reverseWord(words[i]));
        }
    }

    private static String reverseWord(String word) {
        StringBuilder builder = new StringBuilder();

        for (int i = word.length()-1; i >=0 ; i--) {
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }
}
