import java.util.List;
import java.util.stream.Collectors;

public class DigitFilter {

    public static String getDigitsfromString(List<String> stringList) {

        return stringList.stream()
                .map(s -> s.codePoints()
                        .mapToObj(i -> (char) i)
                        .filter(Character::isDigit)
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining());

    }
}