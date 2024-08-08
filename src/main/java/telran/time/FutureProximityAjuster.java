package telran.time;

public class FutureProximityAjuster implements TimePointAjuster {
    TimePoint[] timePoints;

    public FutureProximityAjuster(TimePoint[] timePoints) {
        TimePoint[] sortedTimePoints = java.util.Arrays.copyOf(timePoints, timePoints.length);
        java.util.Arrays.sort(sortedTimePoints);
        this.timePoints = java.util.Arrays.copyOf(sortedTimePoints, sortedTimePoints.length);
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        int index = java.util.Arrays.binarySearch(timePoints, timePoint);
        if (index >= 0) {
            while (timePoints[index].equals(timePoints[index + 1])) {
                index++;
            }
            index++;
        } else {
            index = -index - 1;
        }
        return timePoints[index];
    }
}
