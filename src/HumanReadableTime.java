import org.w3c.dom.ranges.RangeException;

final class TimeFormat {
    private TimeFormat() throws AssertionError {
        throw new AssertionError("Cannot create an instance of utility class.");
    }
    public static String HumanReadable(int seconds) throws IllegalArgumentException {
        if(seconds>359999 || seconds<0) throw new IllegalArgumentException("Argument out of range");

        final int secsInHour=3600;
        final int secsInMinute=60;

        int hours=seconds/secsInHour;
        int minutes=(seconds%secsInHour)/secsInMinute;
        int secs=seconds%secsInMinute;

        return  String.format("%02d:%02d:%02d",hours,minutes,secs);
    }
}