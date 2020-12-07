import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeFormatTest {

    @Test
    void humanReadable_generalExample() {
        assertEquals("15:14:13",TimeFormat.HumanReadable(15*3600+14*60+13));
    }
    @Test
    void humanReadable_argumentLessThanLowerLimit() {
        Exception e=assertThrows(IllegalArgumentException.class,()->TimeFormat.HumanReadable(-1) );
        assertEquals("Argument out of range", e.getMessage());
    }
    @Test
    void humanReadable_argumentMoreThanUpperLimit() {
        Exception e=assertThrows(IllegalArgumentException.class,()->TimeFormat.HumanReadable(360000) );
        assertEquals("Argument out of range", e.getMessage());
    }
    @Test
    void humanReadable_argumentEqualsLowerLimit() {
        assertEquals("00:00:00",TimeFormat.HumanReadable(0));
    }
    @Test
    void humanReadable_argumentEqualsUpperLimit() {
        assertEquals("99:59:59", TimeFormat.HumanReadable(359999));
    }
    @Test
    void humanReadable_singleDigitFormat() {
        assertEquals("01:01:01",TimeFormat.HumanReadable(3661));
    }
}