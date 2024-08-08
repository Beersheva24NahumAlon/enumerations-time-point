package telran.time;

public class TimePoint implements Comparable<TimePoint> {
    private float amount;
    private TimeUnit timeUnit;

    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }

    @Override
    public int compareTo(TimePoint arg) {
        float thisAmountSeconds = amount * timeUnit.getValueOfSeconds();
        float argAmountSeconds = arg.amount * arg.timeUnit.getValueOfSeconds();
        return Float.compare(thisAmountSeconds, argAmountSeconds);
    }

    public float getAmount() {
        return amount;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public boolean equals(Object p) {
        return ((TimePoint) p).compareTo(this) == 0;
    }

    public TimePoint convert(TimeUnit timeUnit) {
        float timePointSeconds = amount * this.timeUnit.getValueOfSeconds();
        float newAmount = timePointSeconds / timeUnit.getValueOfSeconds();
        return new TimePoint(newAmount, timeUnit);
    }

    public TimePoint with(TimePointAjuster ajuster) {
        return ajuster.adjust(this);
    }

}
