import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private Random random = new Random();
    private boolean running = true;

    public WeatherStation() {
        this.temperature = random.nextInt(21) - 10; // Alkuarvona -10 - +10 välillä
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (running) {
            int change = random.nextBoolean() ? 1 : -1;
            temperature += change;

            if (temperature < -10) {
                temperature = -10;
            } else if (temperature > 30) {
                temperature = 30;
            }

            notifyObservers();

            try {
                Thread.sleep(1000 + random.nextInt(4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }
}
