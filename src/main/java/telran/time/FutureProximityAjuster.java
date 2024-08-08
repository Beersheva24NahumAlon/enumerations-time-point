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
        //{1, 3, 5, 5, 5, 7, 9}
        int index = java.util.Arrays.binarySearch(timePoints, timePoint);
        return index < 0 ? timePoints[-index - 1] : timePoints[index + 1];
    }

    public TimePoint[] getTimePoints() {
        return timePoints;
    }
}
