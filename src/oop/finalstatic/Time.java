package oop.finalstatic;
import static oop.finalstatic.TimeValidation.*;

public class Time {
    private static int instanceCount;
    private int hour;
    private int minute;
    private int second;

    // designated constructor
    public Time(int hour, int minute, int second) throws IllegalArgumentException {
        checkHour(hour);
        checkMinute(minute);
        checkSecond(second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        instanceCount++;
    }

    public Time() {
        this(0, 0, 0);
    }

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time(int hour, int minute) {
        this(hour, minute, 0);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) throws IllegalArgumentException {
        checkHour(hour);
        this.hour = hour;
    }

    public void setMinute(int minute) throws IllegalArgumentException {
        checkMinute(minute);
        this.minute = minute;
    }

    public void setSecond(int second) throws IllegalArgumentException {
        checkSecond(second);
        this.second = second;
    }

    public String toUniversalForm() {
        // 21:45:20
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandardForm() {
        // 09:45:20 PM
        int h = (hour == 0 || hour == 12) ? 12 : hour % 12;
        String unit = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", h, minute, second, unit);
    }
}
