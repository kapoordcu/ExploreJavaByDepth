package explore.topics.design.decorator;

// This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
// Facilitates the addition of behaviour to individual objects without inheriting from them
//  This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
// This pattern changes the functionality of objects at runtime without impacting its blueprint or the existing functionality.
public class DecoratorApp {
    public static void main(String[] args) {
        MagicString magicString = new MagicString("Gaurav Kapoor");
        System.out.println(magicString.getVowelsInString());
    }
}

//class MagicString extends String { } // String is final, all you can do is to have String in your class, have a field of type string and can expose the members of the string
// using delegation, keeps the reference of the decorated object
// may/May, not forward calls
// static variation
class MagicString {

    public static void main(String[] args) {
        MagicString string = new MagicString("hello");
        System.out.println("There are " + string.getVowelsInString() + " vowles in '" + string + "'");
    }

    String magicString;  // aggregate the actual object

    public MagicString(String magicString) {
        this.magicString = magicString;
    }

    public long getVowelsInString() {
        return magicString.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> "aeiou".contains(c.toString()))
                .count();
    }

    @Override
    public String toString() {
        return magicString;
    }

    //////////////How Many members you want to delegate to ///////////////
/*    public int length() {
        return magicString.length();
    }

    public boolean isEmpty() {
        return magicString.isEmpty();
    }

    public char charAt(int index) {
        return magicString.charAt(index);
    }

    public int codePointAt(int index) {
        return magicString.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return magicString.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return magicString.codePointCount(beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return magicString.offsetByCodePoints(index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        magicString.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    @Deprecated
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        magicString.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return magicString.getBytes(charsetName);
    }

    public byte[] getBytes(Charset charset) {
        return magicString.getBytes(charset);
    }

    public byte[] getBytes() {
        return magicString.getBytes();
    }

    public boolean contentEquals(StringBuffer sb) {
        return magicString.contentEquals(sb);
    }

    public boolean contentEquals(CharSequence cs) {
        return magicString.contentEquals(cs);
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return magicString.equalsIgnoreCase(anotherString);
    }

    public int compareTo(String anotherString) {
        return magicString.compareTo(anotherString);
    }

    public int compareToIgnoreCase(String str) {
        return magicString.compareToIgnoreCase(str);
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return magicString.regionMatches(toffset, other, ooffset, len);
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return magicString.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public boolean startsWith(String prefix, int toffset) {
        return magicString.startsWith(prefix, toffset);
    }

    public boolean startsWith(String prefix) {
        return magicString.startsWith(prefix);
    }

    public boolean endsWith(String suffix) {
        return magicString.endsWith(suffix);
    }

    public int indexOf(int ch) {
        return magicString.indexOf(ch);
    }

    public int indexOf(int ch, int fromIndex) {
        return magicString.indexOf(ch, fromIndex);
    }

    public int lastIndexOf(int ch) {
        return magicString.lastIndexOf(ch);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        return magicString.lastIndexOf(ch, fromIndex);
    }

    public int indexOf(String str) {
        return magicString.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return magicString.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return magicString.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return magicString.lastIndexOf(str, fromIndex);
    }

    public String substring(int beginIndex) {
        return magicString.substring(beginIndex);
    }

    public String substring(int beginIndex, int endIndex) {
        return magicString.substring(beginIndex, endIndex);
    }

    public CharSequence subSequence(int beginIndex, int endIndex) {
        return magicString.subSequence(beginIndex, endIndex);
    }

    public String concat(String str) {
        return magicString.concat(str);
    }

    public String replace(char oldChar, char newChar) {
        return magicString.replace(oldChar, newChar);
    }

    public boolean matches(String regex) {
        return magicString.matches(regex);
    }

    public boolean contains(CharSequence s) {
        return magicString.contains(s);
    }

    public String replaceFirst(String regex, String replacement) {
        return magicString.replaceFirst(regex, replacement);
    }

    public String replaceAll(String regex, String replacement) {
        return magicString.replaceAll(regex, replacement);
    }

    public String replace(CharSequence target, CharSequence replacement) {
        return magicString.replace(target, replacement);
    }

    public String[] split(String regex, int limit) {
        return magicString.split(regex, limit);
    }

    public String[] split(String regex) {
        return magicString.split(regex);
    }

    public static String join(CharSequence delimiter, CharSequence... elements) {
        return String.join(delimiter, elements);
    }

    public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        return String.join(delimiter, elements);
    }

    public String toLowerCase(Locale locale) {
        return magicString.toLowerCase(locale);
    }

    public String toLowerCase() {
        return magicString.toLowerCase();
    }

    public String toUpperCase(Locale locale) {
        return magicString.toUpperCase(locale);
    }

    public String toUpperCase() {
        return magicString.toUpperCase();
    }

    public String trim() {
        return magicString.trim();
    }

    public char[] toCharArray() {
        return magicString.toCharArray();
    }

    public static String format(String format, Object... args) {
        return String.format(format, args);
    }

    public static String format(Locale l, String format, Object... args) {
        return String.format(l, format, args);
    }

    public static String valueOf(Object obj) {
        return String.valueOf(obj);
    }

    public static String valueOf(char[] data) {
        return String.valueOf(data);
    }

    public static String valueOf(char[] data, int offset, int count) {
        return String.valueOf(data, offset, count);
    }

    public static String copyValueOf(char[] data, int offset, int count) {
        return String.copyValueOf(data, offset, count);
    }

    public static String copyValueOf(char[] data) {
        return String.copyValueOf(data);
    }

    public static String valueOf(boolean b) {
        return String.valueOf(b);
    }

    public static String valueOf(char c) {
        return String.valueOf(c);
    }

    public static String valueOf(int i) {
        return String.valueOf(i);
    }

    public static String valueOf(long l) {
        return String.valueOf(l);
    }

    public static String valueOf(float f) {
        return String.valueOf(f);
    }

    public static String valueOf(double d) {
        return String.valueOf(d);
    }

    public String intern() {
        return magicString.intern();
    }

    public IntStream chars() {
        return magicString.chars();
    }

    public IntStream codePoints() {
        return magicString.codePoints();
    }*/
}