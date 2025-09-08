import java.util.Scanner;

public class Character {
    private State state;
    private int level, experience, health;
    private String name;
    private static final Scanner scanner = new Scanner(System.in);

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getExperience() {
        return experience;
    }

    public void gainExperience(int points) {
        // multiply points by a random percentage between 90% and 150%
        points = (int) (points * (0.9 + Math.random() * 0.6));
        this.experience += points;
    }

    public void increaseHealth(int points) {
        this.health += points;
    }

    public void decreaseHealth(int points) {
        this.health -= points;
    }

    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);
        System.out.println("Current State: " + state.getClass().getSimpleName());
    }

    public void play() {
        while (true) {
            displayStatus();
            System.out.println("Choose an action:");
            for (Action action : Action.values()) {
                if (action.isAvailable(state)) {
                    System.out.println((action.ordinal() + 1) + ". " + action.name());
                }
            }
            int choice = scanner.nextInt();
            Action selectedAction = Action.values()[choice - 1];
            if (selectedAction.isAvailable(state)) {
                switch (selectedAction) {
                    case TRAIN:
                        state.train();
                        break;
                    case MEDITATE:
                        state.meditate();
                        break;
                    case FIGHT:
                        state.fight();
                        break;
                    case EXIT:
                        return;
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}