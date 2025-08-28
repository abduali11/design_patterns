// Map on abstracti classin, joka määrittelee luokan `Map` ja sen abstraktin metodin `createTile()`.
// Tämä metodi on tarkoitettu luomaan `Tile`-objekteja, mutta se ei ole toteutettu tässä luokassa.
// Tämä on esimerkki siitä, miten abstrakti luokka voi määritellä metodin, joka on tarkoitettu aliluokkien toteutettavaksi.

public abstract class Map {
    public abstract Tile createTile();

    public void display(Tile[][] map) {
        for (Tile[] row : map) {
            for (Tile tile : row) {
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
