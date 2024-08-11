package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FutureProximityAjusterTest {
    TimePoint eightyMinutes = new TimePoint(80, TimeUnit.MINUTE);
    TimePoint twoHours = new TimePoint(2, TimeUnit.HOUR);
    TimePoint twoAndHalfHours = new TimePoint(2.5f, TimeUnit.HOUR);
    TimePoint hundredTwentyMinutes = new TimePoint(120, TimeUnit.MINUTE);
    TimePoint ninetyMinutes = new TimePoint(90, TimeUnit.MINUTE);
    TimePoint[] timePoints = { twoHours, twoAndHalfHours, hundredTwentyMinutes, ninetyMinutes };
    FutureProximityAjuster futureProximityAjuster = new FutureProximityAjuster(timePoints);

    @Test
    void adjustTest() {
        assertEquals(ninetyMinutes, futureProximityAjuster.adjust(eightyMinutes));
        assertEquals(twoAndHalfHours, futureProximityAjuster.adjust(twoHours));
        assertEquals(TimeUnit.HOUR, futureProximityAjuster.adjust(twoHours).getTimeUnit());
        assertEquals(twoAndHalfHours, futureProximityAjuster.adjust(hundredTwentyMinutes));
        assertEquals(TimeUnit.MINUTE, futureProximityAjuster.adjust(hundredTwentyMinutes).getTimeUnit());
        assertEquals(null, futureProximityAjuster.adjust(twoAndHalfHours));
    }
}