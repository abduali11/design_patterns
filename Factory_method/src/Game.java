import java.util.Random;

public class Game {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;

        // luo CityMap
        CityMap cityMap = new CityMap();


        Tile[][] map = new Tile[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = cityMap.createTile();
            }
        }

        cityMap.display(map);
    }
}