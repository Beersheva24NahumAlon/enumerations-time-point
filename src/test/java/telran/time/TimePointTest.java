package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TimePointTest {
    TimePoint twoHours = new TimePoint(2, TimeUnit.HOUR);
    TimePoint twoAndHalfHours = new TimePoint(2.5f, TimeUnit.HOUR);
    TimePoint hundredTwentyMinutes = new TimePoint(120, TimeUnit.MINUTE);
    TimePoint ninetyMinutes = new TimePoint(90, TimeUnit.MINUTE);

    @Test
    void convertTest() {
        assertEquals(hundredTwentyMinutes, twoHours.convert(TimeUnit.MINUTE));
    }

    @Test
    void equalsTest() {
        assertEquals(hundredTwentyMinutes, twoHours);
    }

    @Test
    void compareToTest() {
        assertTrue(twoAndHalfHours.compareTo(twoHours) > 0);
        assertTrue(twoHours.compareTo(hundredTwentyMinutes) == 0);
        assertTrue(ninetyMinutes.compareTo(twoHours) < 0);
    }
}