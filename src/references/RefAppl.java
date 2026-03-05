package references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RefAppl {
    static void main() {
        //::
        // static method reference classname::method  -  Integer::sum
        // Instance Method of object Instance::method -  person1::greet
        // String:: compareToIgnoreCase
        // ArrayList::new

        List<Integer> arrayList = Arrays.asList(1,5,2,10,5,9);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        System.out.println("=======================");
        Consumer<Integer> printer1 = v->{
            System.out.println(v);
        };
        arrayList.forEach(printer1);
        System.out.println("======================");
        arrayList.forEach(v -> System.out.println(v));
        System.out.println("==========ref============");
        arrayList.forEach(System.out::println);
        System.out.println("======================");
        BinaryOperator<Integer> addFunction = MathUtils::add;
        int res = addFunction.apply(5,10);
        System.out.println(res);
        BinaryOperator<Integer> subFunction = MathUtils::sub;
        res = subFunction.apply(12,52);
        System.out.println(res);

        Person p1 = new Person("Vasya");
        Runnable grAct = p1::greet;
        grAct.run();

        Printer2 pr2 = ConsolePrinter::print2;
        pr2.print2(new ConsolePrinter(), "hello perfect group");

        List<String> arList = Arrays.asList("aaa","Bdg","Aaa", "cda");
        arList.sort(String::compareTo);
        System.out.println(arList);
        arList.sort(String::compareToIgnoreCase);
        System.out.println(arList);


        Supplier<ArrayList<String>> listCreator = () -> new ArrayList<>();
        ArrayList<String> l1 = listCreator.get();
        l1.add("Hello");
        System.out.println(l1);

        Supplier<ArrayList<String>> listCreator1 = ArrayList::new;
        ArrayList<String> l2 = listCreator.get();
        l2.add("Reference");
        System.out.println(l2);
        /*
        Math::max            (a,b) -> Math.max(a,b)
        person::greet        () -> person.greet()
        String::compareTo    (s1,s2) -> s1.compareTo(s2)
        ArrayList::new       () -> new ArrayList()
         */

    }
}
class MathUtils {
    public static int add(int a, int b) {
        return a+b;
    }
    public static int sub(int a, int b) {
        return a-b;
    }
}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public void greet(){
        System.out.println("Hello! My name is " + name);
    }
}
interface Printer2 {
    void print2(ConsolePrinter pr, String message);
}