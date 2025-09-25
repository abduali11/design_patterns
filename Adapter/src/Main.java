import java.util.Scanner;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        CalendarToCustomDateAdapter dateAdapter = new CalendarToCustomDateAdapter();


        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1; // Adjust to 1-based month
        int year = Calendar.getInstance().get(Calendar.YEAR);
        dateAdapter.setDay(day);
        dateAdapter.setMonth(month);
        dateAdapter.setYear(year);

        System.out.println("Starting Date: " + dateAdapter.getDay() + "." + dateAdapter.getMonth() + "." + dateAdapter.getYear());


        Scanner scanner = new Scanner(System.in);
        System.out.print("How many days would you like to add? : ");
        int days = scanner.nextInt();
        dateAdapter.addDays(days);

        System.out.println("New Date: " + dateAdapter.getDay() + "." + dateAdapter.getMonth() + "." + dateAdapter.getYear());
    }
}
