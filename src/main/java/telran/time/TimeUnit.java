package telran.time;

public enum TimeUnit {
    SECOND(1), MINUTE(60), HOUR(3600);
    private int valueOfSeconds;

    private TimeUnit(int valueOfSeconds) {
        this.valueOfSeconds = valueOfSeconds;
    }

    public int getValueOfSeconds() {
        return valueOfSeconds;
    }

    public float between(TimePoint p1, TimePoint p2) {
        float pAmountOfSeconds1 = p1.getAmount() * p1.getTimeUnit().getValueOfSeconds();
        float pAmountOfSeconds2 = p2.getAmount() * p2.getTimeUnit().getValueOfSeconds();
        return (pAmountOfSeconds2 - pAmountOfSeconds1) / valueOfSeconds;
    }
}
