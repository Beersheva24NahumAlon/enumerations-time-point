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
        int index = binarySearch(timePoints, timePoint);
        index = index < 0 ? -index - 1 : index + 1;
        return index < 0 || index >= timePoints.length ? null : timePoints[index].convert(timePoint.getTimeUnit());
    }

    //This binary search method searches last entry of key in sorted array
    public static <T extends Comparable<T>> int binarySearch(T[] ar, T key) {
        int start = 0;
        int finish = ar.length - 1;
        int middle = (start + finish) / 2;
        while (start <= finish) {
            if (key.compareTo(ar[middle]) >= 0) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = (start + finish) / 2;
        }
        return key.equals(ar[middle]) ? middle : -start - 1;
    }
}
