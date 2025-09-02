public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();
        DisplayObserver observer1 = new DisplayObserver("Tarkkailija 1");
        DisplayObserver observer2 = new DisplayObserver("Tarkkailija 2");
        DisplayObserver observer3 = new DisplayObserver("Tarkkailija 3");


        station.addObserver(observer1);
        station.addObserver(observer2);
        station.addObserver(observer3);


        Thread stationThread = new Thread(station);
        stationThread.start();


        Thread.sleep(15000);
        station.removeObserver(observer2);
        System.out.println("Tarkkailija 2 poistettiin.");


        Thread.sleep(10000);


        station.stop();
    }
}
