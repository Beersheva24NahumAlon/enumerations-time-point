package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FutureProximityAjusterTest {
    TimePoint eightyMinutes = new TimePoint(80, TimeUnit.MINUTE);
    TimePoint twoHours = new TimePoint(2, TimeUnit.HOUR);
    TimePoint twoAndHalfHours = new TimePoint(2.5f, TimeUnit.HOUR);
    TimePoint hundredTwentyMinutes = new TimePoint(120, TimeUnit.MINUTE);
    TimePoint ninetyMinutes = new TimePoint(90, TimeUnit.MINUTE);
    TimePoint[] timePoints = { twoHours, twoAndHalfHours, hundredTwentyMinutes, ninetyMinutes };
    FutureProximityAjuster futureProximityAjuster = new FutureProximityAjuster(timePoints);
    
    private <T extends Comparable<T>> boolean isArraySorted(T[] array) {
        int i = 0;
        while (i < array.length - 1 && array[i].compareTo(array[i + 1]) <= 0) {
            i++;
        }
        return i == array.length - 1;
    }

    @Test
    void constructorFutureProximityAjusterTest() {
        assertTrue(isArraySorted(futureProximityAjuster.getTimePoints()));
    }

    @Test
    void adjustTest() {
        assertEquals(ninetyMinutes, futureProximityAjuster.adjust(eightyMinutes));
        assertEquals(twoAndHalfHours, futureProximityAjuster.adjust(twoHours));
    }
}
