package telran.time;

public class PlusTimePointAjuster implements TimePointAjuster {
    private int amount;
    private TimeUnit timeUnit;

    public PlusTimePointAjuster(int amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        TimePoint point = timePoint.convert(timeUnit);
        float amountPoint = point.getAmount() + amount;
        TimePoint pointTmp = new TimePoint(amountPoint, timeUnit);
        return pointTmp.convert(timePoint.getTimeUnit());
    }
}