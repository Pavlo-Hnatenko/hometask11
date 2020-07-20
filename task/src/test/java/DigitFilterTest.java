import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitFilterTest {

    @Test
    void getDigitsfromString() {

        List<String> strings = List.of("string 1393 text", "209809087876 string 3 09text", "45   098");
        assertEquals("139320980908787630945098", DigitFilter.getDigitsfromString(strings));

        strings = List.of("8");
        assertEquals("8", DigitFilter.getDigitsfromString(strings));

        strings = List.of("8", "sdfkg999", "  1ssdfgh", "     ");
        assertEquals("89991", DigitFilter.getDigitsfromString(strings));
    }
}