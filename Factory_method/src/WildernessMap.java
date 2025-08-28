import java.util.Random;

public class WildernessMap extends Map{
    @Override
    public Tile createTile() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new ForestTile();
        } else {
            return new WaterTile();
        }
    }
}
