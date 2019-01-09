package lookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


//interface Function<E, F> {
//    F apply(E e);
//}

//class ToUpperCase implements Function<String, String> {
//    @Override
//    public String apply(String s) {
//        return s.toUpperCase();
//    }
//}

public class DoAMap {

    public static List<String> map(List<String> in, Function<String, String> op) {
        List<String> results = new ArrayList<>();
        for (String s : in) {
            results.add(op.apply(s));
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Fred", "Jim", "Sheila");

        List<String> shouted = map(names, s -> s.toUpperCase());
        System.out.println(shouted);

        List<String> empty = new ArrayList<>();
        List<String> odd = map(empty, s -> s.toUpperCase());
        System.out.println(odd);
    }
}
