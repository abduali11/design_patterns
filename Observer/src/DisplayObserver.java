public class DisplayObserver implements WeatherObserver {
    private String name;

    public DisplayObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " sai uuden lämpötilan: " + temperature + " °C");
    }
}
