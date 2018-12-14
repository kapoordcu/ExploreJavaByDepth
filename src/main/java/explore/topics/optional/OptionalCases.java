package explore.topics.optional;


import java.util.Optional;

public class OptionalCases {

    public static void main(String[] args) {


        // empty Optional object:
        Optional<String> emptyOpt = Optional.empty();
        System.out.println("value = " + emptyOpt.toString() + " and isPresent="  + emptyOpt.isPresent());

        // non-empty Optional object:
        Optional<String> staticOpt = Optional.of("OPT_VAL");
        System.out.println("value = " + staticOpt.toString() + " and isPresent="  + staticOpt.isPresent());

        //the argument passed to the of method cannot be null, otherwise, we will get a NullPointerException:
        String name = null;
        // Optional<String> nullExceptionOpt = Optional.of(name);
        Optional<String> nullOpt = Optional.ofNullable(name);
        System.out.println("value = " + nullOpt.toString() + " and isPresent="  + nullOpt.isPresent());

        Optional<String> opt = Optional.of("whenIfPresent");
        opt.ifPresent(value -> System.out.println("value = " + value));

        String defaultName = null;
        String defaultValue = Optional.ofNullable(defaultName).orElse("defaultValue");
        System.out.println("value = " + defaultValue);

        String defaultNameGet = null;
        String defaultValueGet = Optional.ofNullable(defaultNameGet).orElseGet(() -> "defaultNameGet");
        System.out.println("value = " + defaultValueGet);



        String text = "Text present";

        String defaultText = Optional.ofNullable(text).orElseGet(OptionalCases::callDefaultMethod);
        System.out.println("value = " + defaultText);

        defaultText = Optional.ofNullable(text).orElse(callDefaultMethod());
        System.out.println("value = " + defaultText);
    }


    public static String callDefaultMethod() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }


}
