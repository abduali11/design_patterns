import java.util.Random;

public class CityMap extends Map {
    @Override
    public Tile createTile() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new BuildingTile();
        } else {
            return new RoadTile();
        }
    }

}
