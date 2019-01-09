package lookup;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseAMap {
    public static void main(String[] args) {
        Map<String, String> mss = new HashMap<>();
        mss.put("Fred", "Jones");

        String lastName = mss.get("Freddy");
        if (lastName != null) {
            System.out.println("Dear Mr. " + lastName.toUpperCase());
        }

        System.out.println("-----------------------");
        Optional<Map<String, String>> optM = Optional.of(mss);
        Optional<String> optS = optM.map(m -> m.get("Freddy"));
        Optional<String> optS2 = optS.map(s -> s.toUpperCase());
        Optional<String> optS3 = optS2.map(s -> "Dear Mr. " + s);
        optS3.ifPresent(s -> System.out.println(s));

        System.out.println("-----------------------");
        Optional.of(mss)
                .map(m -> m.get("Freddy"))
                .map(s -> s.toUpperCase())
                .map(s -> "Dear Mr. " + s)
                .ifPresent(s -> System.out.println(s));

    }
}
