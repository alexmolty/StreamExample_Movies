package references.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAppl {
    static void main() {
        Movie[] movies = {
                // Группа 2022
                new Movie("The Batman", 2022, 7.8),
                new Movie("Top Gun: Maverick", 2022, 8.3),
                new Movie("Avatar: The Way of Water", 2022, 7.6),
                new Movie("Everything Everywhere All at Once", 2022, 7.8),

                // Группа 2010
                new Movie("Inception", 2010, 8.8),
                new Movie("Shutter Island", 2010, 8.2),
                new Movie("The Social Network", 2010, 7.8),
                new Movie("Toy Story 3", 2010, 8.2),

                // Группа 2019
                new Movie("Parasite", 2019, 8.5),
                new Movie("The Irishman", 2019, 7.8),
                new Movie("Joker", 2019, 8.4),
                new Movie("1917", 2019, 8.2)
        };
        Stream<Movie> str1 = Arrays.stream(movies);

        List<Movie> l1 = new ArrayList<>(Arrays.asList(movies));
        Stream<Movie> str2 = l1.stream();
        //map.entrySet().stream();

        Stream<String> str3 = Stream.of("a1", "a2","b1", "b2");
        Stream<Integer> str4 = Stream.of(1,2,4,6,7,8,23);

        IntStream streamFromString = "12345".chars();

        Stream<String> str5 = Stream.<String>builder()
                .add("a1")
                .add("a2")
                .add("a3")
                .build();

        IntStream.iterate(1, x-> x*2)
                .limit(10)
                .forEach(System.out::println);

        int x=1;
        for(int i=0; i < 10; i++) {
            System.out.println(x);
            x*=2;
        }

        Stream.generate(()-> "hello ")
                .limit(5)
                .forEach(System.out::println)
                ;

        IntStream.range(0, 5).forEach(i-> System.out.println("HI"));

        Random r = new Random();
        Stream.generate(r::nextBoolean)
                .limit(5)
                .forEach(System.out::println);

        IntStream.range(0,5).forEach(System.out::println);

        IntStream is1 = IntStream.range(0,5);
        long sum = is1.sum();
        System.out.println(sum);
        is1 = IntStream.range(1,5);
        sum = is1.sum();
        System.out.println(sum);
    }
}
