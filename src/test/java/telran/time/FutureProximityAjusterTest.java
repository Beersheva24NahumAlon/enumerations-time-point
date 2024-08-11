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

    @Test
    void binarySearchTest() {
        TimePoint[] timePointsSorted = { ninetyMinutes, twoHours, hundredTwentyMinutes, twoHours, twoAndHalfHours };
        TimePoint threeHours = new TimePoint(3, TimeUnit.HOUR);
        TimePoint hundredMinutes = new TimePoint(100, TimeUnit.MINUTE);
        assertEquals(0, FutureProximityAjuster.binarySearch(timePointsSorted, ninetyMinutes));
        assertEquals(3, FutureProximityAjuster.binarySearch(timePointsSorted, twoHours));
        assertEquals(4, FutureProximityAjuster.binarySearch(timePointsSorted, twoAndHalfHours));
        assertEquals(-1, FutureProximityAjuster.binarySearch(timePointsSorted, eightyMinutes));
        assertEquals(-2, FutureProximityAjuster.binarySearch(timePointsSorted, hundredMinutes));
        assertEquals(-6, FutureProximityAjuster.binarySearch(timePointsSorted, threeHours));
    }
}