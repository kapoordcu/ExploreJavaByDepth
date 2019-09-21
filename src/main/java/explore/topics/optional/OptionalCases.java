//package explore.topics.optional;
//
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class OptionalCases {
//
//    public static void main(String[] args) {
//
//
///*        // empty Optional object:
//        Optional<String> emptyOpt = Optional.empty();
//        System.out.println("value = " + emptyOpt.toString() + " and isPresent="  + emptyOpt.isPresent());
//
//        // non-empty Optional object:
//        Optional<String> staticOpt = Optional.of("OPT_VAL");
//        System.out.println("value = " + staticOpt.toString() + " and isPresent="  + staticOpt.isPresent());
//
//        //the argument passed to the of method cannot be null, otherwise, we will get a NullPointerException:
//        String name = null;
//        // Optional<String> nullExceptionOpt = Optional.of(name);
//        Optional<String> nullOpt = Optional.ofNullable(name);
//        System.out.println("value = " + nullOpt.toString() + " and isPresent="  + nullOpt.isPresent());
//
//        Optional<String> opt = Optional.of("whenIfPresent");
//        opt.ifPresent(value -> System.out.println("value = " + value));
//
//        String defaultName = null;
//        String defaultValue = Optional.ofNullable(defaultName).orElse("defaultValue");
//        System.out.println("value = " + defaultValue);
//
//        String defaultNameGet = null;
//        String defaultValueGet = Optional.ofNullable(defaultNameGet).orElseGet(() -> "defaultNameGet");
//        System.out.println("value = " + defaultValueGet);
//
//
//
//        String text = "Text present";
//
//        String defaultText = Optional.ofNullable(text).orElseGet(OptionalCases::callDefaultMethod);
//        System.out.println("value = " + defaultText);
//
//        defaultText = Optional.ofNullable(text).orElse(callDefaultMethod());
//        System.out.println("value = " + defaultText);
//
//         String nullName = null;
//        String nameException = Optional.ofNullable(nullName).orElseThrow(
//                IllegalArgumentException::new);
//
//        Optional<String> opt = Optional.ofNullable(null);
//        String name = opt.get(); // java.util.NoSuchElementException: No value present
//
//                */
//
//
//    }
//
//
//    public boolean priceIsInRange1(Modem modem) {
//        return Optional.ofNullable(modem).map(Modem::getPrice).filter(p -> p>10).filter(p -> p < 15).isPresent();
//    }
//
//    public static String callDefaultMethod() {
//        System.out.println("Getting Default Value");
//        return "Default Value";
//    }
//
//    @Test
//    public void whenFiltersWithoutOptional_thenCorrect() {
//        assertTrue(priceIsInRange1(new Modem(10.1)));
//        assertFalse(priceIsInRange1(new Modem(9.9)));
//        assertFalse(priceIsInRange1(new Modem(null)));
//        assertFalse(priceIsInRange1(new Modem(15.5)));
//        assertFalse(priceIsInRange1(null));
//    }
//
//}
//
//
//
//class Modem {
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    private Double price;
//
//    public Modem(Double price) {
//        this.price = price;
//    }
//}