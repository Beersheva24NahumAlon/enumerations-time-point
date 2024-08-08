package telran.time;

public class TimePoint implements Comparable<TimePoint> {
    private float amount;
    private TimeUnit timeUnit;

    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }

    @Override
    public int compareTo(TimePoint o) {
        //TODO
        return 0;
    }

    public float getAmount() {
        return amount;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public boolean equals(Object p) {
        //TODO
        return false;
    }

    public TimePoint convert(TimeUnit timeUnit) {
        //TODO
        return null;
    }

    public TimePoint with(TimePointAjuster ajuster) {
        return ajuster.adjust(this);
    }

}
