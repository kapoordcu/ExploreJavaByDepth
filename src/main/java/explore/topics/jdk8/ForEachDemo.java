package explore.topics.jdk8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ForEachDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 4, 5, 7, 8);
        //integers.forEach(System.out::println);

        Stream<Integer> s = integers.stream();
        s.forEach(System.out::println); // Will work
        //s.forEach(System.out::println); // Exception: stream has already been operated upon or closed

        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now(ZoneId.of("GMT")); // Human readable
        Instant now = Instant.now(); // Machine Readable
        System.out.println(localTime);


    }
}

