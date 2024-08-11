package telran.time;

public class FutureProximityAjuster implements TimePointAjuster {
    TimePoint[] timePoints;

    public FutureProximityAjuster(TimePoint[] timePoints) {
        TimePoint[] sortedTimePoints = java.util.Arrays.copyOf(timePoints, timePoints.length);
        java.util.Arrays.sort(sortedTimePoints);
        this.timePoints = sortedTimePoints;
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        int index = getLeastOfGreaterIndex(timePoint);
        return (index < 0 || index >= timePoints.length) ? null : timePoints[index].convert(timePoint.getTimeUnit());
    }

    private int getLeastOfGreaterIndex(TimePoint timePoint) {
        int start = 0;
        int finish = timePoints.length - 1;
        int middle = start + (finish - start) / 2;
        while (start <= finish) {
            if (timePoint.compareTo(timePoints[middle]) >= 0) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = start + (finish - start) / 2;
        }
        return start;
    }
}