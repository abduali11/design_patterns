package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    // Logger is a singleton class
    // Logger logs messages to a file.
    // Logger first asks for a filename when opened, and creates such a file if it does not exist.

    private static Logger instance = null;
    private String filename;
    private BufferedWriter writer;

    // Writer
    public void write(String message){
        // Write message to file
        if (writer != null) {
            try {
                writer.write(message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Logger filename not set.");
        }


    }

    // Singleton constructor
    private Logger() {
        filename = null;
    }

    // Singleton instance getter
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFilename(String filename) {
        this.filename = filename;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true)); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    // Close logger
    public void close() {
        // Close writer and then Logger
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        filename = null;
        instance = null;
    }

}