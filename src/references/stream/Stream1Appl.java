package references.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1Appl {
    static void main() {
        List<Integer> nums = List.of(1, 2, 3, -4, 5, 6, -2, 626, 3, 4);
        nums.stream().filter(n -> n > 0 && n % 2 == 0).forEach(System.out::println);
//        for (Integer n : nums) {
//            if (n > 0 && n % 2 == 0) {
//                System.out.println(n);
//            }
//        }
        System.out.println("++++++++++++++++++");
        nums.stream().sorted().forEach(System.out::println);
    }
}
