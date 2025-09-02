import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Logger program.");

        try {
            // MAIN LOOP:
            while (true) {
                Singleton.Logger logger = Singleton.Logger.getInstance();

                // Filename loop
                if (logger.getFilename() == null) {
                    System.out.println("Input 'exit' to exit program.");
                    System.out.println("or enter the filename to log to:");
                    String filename = scanner.nextLine();
                    if (filename.equals("exit")) {
                        return;
                    }
                    logger.setFilename(filename);
                } else {
                    // Logging loop
                    System.out.println("Enter 'exit' to close logger.");
                    System.out.println("or enter a message to log:");
                    String message = scanner.nextLine();
                    if (message.equals("exit")) {
                        logger.close();
                        System.out.println("Logger closed.");
                        // Breaks out of the logging loop, returns to filename loop
                    } else {
                        logger.write(message);
                    }
                }

                // MAIN LOOP ENDS:
            }} catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}