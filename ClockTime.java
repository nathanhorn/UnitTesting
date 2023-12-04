
/**
 * Write a description of class ClockTime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClockTime {
    // instance variables 
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructor for objects of class ClockTime (no paramenters)
     */
     public ClockTime() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    /**
     * Constructor for objects of class ClockTime (with paramenters)
     */
    public ClockTime(int hour, int minute, int second) {
        //Hours
        if (hour > 24) {
            this.hour = hour % 24;

        } else if (hour < 0) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
        //Minutes
        if (minute > 59) {
            this.hour += minute / 60;
            this.minute = minute % 60;
        } else if (minute < 0) {
            this.minute = 0;
        } else {
            this.minute = minute;
        }
        //Seconds
        if (second > 59) {
            this.minute += second / 60;
            this.second = second % 60;
        } else if (second < 0) {
            this.second = 0;
        } else {
            this.second = second;
        }
    }
    
    /**
     * Getter methods for each instance variables
     */
    //Hours
    public int getHour() { 
        return this.hour;
    }
    //Minutes
    public int getMinute() { 
        return this.minute;
    }
    //Seconds
    public int getSecond() { 
        return this.second;
    }

    /**
     * Setter methods for each instance variables
     */
    //Hours
    public void setHour(int hour) {
        if (hour >= 0 && hour <= 24) {
            this.hour = hour;
        }
    }
    //Minutes
    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
    }
    //Seconds
    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
    }

    /**
     * Methods to create Strings
     */
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute,
            this.second); 
    }

    public String toString12() {
        String meridiem;
        if (this.hour < 12) {
            meridiem = "A.M.";
        } else {
            meridiem = "P.M.";
        }
        int formatHour ;
        if (this.hour > 12) {
            formatHour = this.hour - 12;
        } else {
            formatHour = this.hour;
        }
        return String.format("%02d:%02d:%02d%s", formatHour, this.minute, 
            this.second,meridiem);
    }

    /**
     * Methods to calculate and compare
     */
    public void advance(int seconds) {
        if (seconds > 0) {
            this.second += seconds;
            this.minute += this.second / 60;
            this.second %= 60;
            this.hour += this.minute / 60;
            this.minute %= 60;
            this.hour %= 24;
        }
    }

    public boolean equals(ClockTime TestClockTime) {
        return this.hour == TestClockTime.getHour() &&
        this.minute == TestClockTime.getMinute() &&
        this.second == TestClockTime.getSecond();
    }
}