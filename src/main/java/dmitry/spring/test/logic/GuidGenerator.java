package dmitry.spring.test.logic;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class GuidGenerator {

    public static String generateGUID() {
        List<String> guidParts = new ArrayList<>();
        guidParts.add(Utils.getRandomHexString(8));
        guidParts.add(Utils.getRandomHexString(4));
        guidParts.add(Utils.getRandomHexString(4));
        guidParts.add(Utils.getRandomHexString(4));
        guidParts.add(Utils.getRandomHexString(12));
        return guidParts.stream()
                .collect(joining("-"));
    }
}
