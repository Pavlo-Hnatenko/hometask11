import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> strings = List.of("string 1393 text", "209809087876 string 3 09text", "45   098");
        System.out.println(DigitFilter.getDigitsfromString(strings));

    }
}
