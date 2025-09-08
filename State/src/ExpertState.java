public class ExpertState extends State {
    public ExpertState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training as an Expert.");
        character.gainExperience(30);
        levelUp();
    }

    @Override
    public void meditate() {
        System.out.println("Meditating as an Expert.");
        character.increaseHealth(20);
    }

    @Override
    public void fight() {
        System.out.println("Fighting as an Expert.");
        character.decreaseHealth(10);
        character.gainExperience(40);
        levelUp();
    }

    @Override
    public void levelUp() {
        if (character.getExperience() >= 300) {
            System.out.println("You have reached the maximum level as an Expert!");
        }
    }
}
