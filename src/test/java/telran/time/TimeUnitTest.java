package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TimeUnitTest {
    TimePoint twoHours = new TimePoint(2, TimeUnit.HOUR);
    TimePoint twoAndHalfHours = new TimePoint(2.5f, TimeUnit.HOUR);

    @Test
    void betweenTest() {
        assertEquals(0.5f, TimeUnit.HOUR.between(twoHours, twoAndHalfHours));
        assertEquals(30, TimeUnit.MINUTE.between(twoHours, twoAndHalfHours));
        assertEquals(1800, TimeUnit.SECOND.between(twoHours, twoAndHalfHours));
        assertEquals(-0.5f, TimeUnit.HOUR.between(twoAndHalfHours, twoHours));
        assertEquals(-30, TimeUnit.MINUTE.between(twoAndHalfHours, twoHours));
        assertEquals(-1800, TimeUnit.SECOND.between(twoAndHalfHours, twoHours));
    }
}