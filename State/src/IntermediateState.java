public class IntermediateState extends State {
    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training as an Intermediate.");
        character.gainExperience(20);
        levelUp();
    }

    @Override
    public void meditate() {
        System.out.println("Meditating as an Intermediate.");
        character.increaseHealth(10);
    }

    @Override
    public void fight() {
        System.out.println("Intermediates cannot fight.");
    }

    @Override
    public void levelUp() {
        if (character.getExperience() >= 200) {
            character.setState(new ExpertState(character));
            System.out.println("Leveled up to Expert!");
        }
    }
}