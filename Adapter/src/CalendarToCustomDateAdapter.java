import java.util.Calendar;

public class CalendarToCustomDateAdapter implements CustomDateInterface {

    private final Calendar dateCalendar;

    public CalendarToCustomDateAdapter() {
        this.dateCalendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        dateCalendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        dateCalendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        dateCalendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return dateCalendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return dateCalendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return dateCalendar.get(Calendar.YEAR);
    }

    @Override
    public void addDays(int days) {
        dateCalendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
