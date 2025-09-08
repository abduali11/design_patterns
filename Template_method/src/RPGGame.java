import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RPGGame extends Game {
    private List<Hero> heroes;
    private List<Monster> monsters;
    private int currentTurn;

    @Override
    public void initializeGame(int numberOfPlayers) {
        heroes = new ArrayList<>();
        monsters = new ArrayList<>();

        // Initialize players
        for (int i = 0; i < numberOfPlayers; i++) {
            heroes.add(new Hero("Hero " + (i + 1), 100, new Random().nextInt(10) + 10));
        }

        // Initialize monsters
        monsters.add(new Monster("Goblin", 50, 8));
        monsters.add(new Monster("Orc", 80, 12));
        monsters.add(new Monster("Dragon", 150, 20));

        currentTurn = 0;

        System.out.println("Game initialized with " + numberOfPlayers + " players and " + monsters.size() + " monsters.");
    }

    @Override
    public boolean endOfGame() {
        // Game ends if all players are dead or all monsters are defeated
        boolean allPlayersDead = heroes.stream().noneMatch(Hero::isAlive);
        boolean allMonstersDefeated = monsters.stream().noneMatch(Monster::isAlive);

        return allPlayersDead || allMonstersDefeated;
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Hero hero = heroes.get(playerIndex);
        if (hero.isAlive()) {
            Monster monster = monsters.get(currentTurn % monsters.size());
            if (monster.isAlive()) {

                // Hero attacks monster
                monster.takeDamage(hero.attack());
                System.out.println(hero.getName() + " attacks " + monster.getName() + " for " + hero.attack() + " damage!");

                // Monster attacks hero
                if (monster.isAlive()) {
                    hero.takeDamage(monster.attack());
                    System.out.println(monster.getName() + " attacks " + hero.getName() + " for " + monster.attack() + " damage!");
                } else {
                    System.out.println(monster.getName() + " has been defeated!");
                }
            }

            currentTurn++;
        }
    }

    @Override
    public void displayWinner() {
        boolean allPlayersDead = heroes.stream().noneMatch(Hero::isAlive);
        boolean allMonstersDefeated = monsters.stream().noneMatch(Monster::isAlive);

        if (allMonstersDefeated) {
            System.out.println("Players win! All monsters have been defeated!");
        } else if (allPlayersDead) {
            System.out.println("Monsters win! All players have been slain!");
        }
    }
}