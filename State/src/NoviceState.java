public class NoviceState extends State {
    public NoviceState(Character character) {
        super(character);
    }

    @Override
    public void train() {
        System.out.println("Training as a Novice.");
        character.gainExperience(10);
        levelUp();
    }

    @Override
    public void meditate() {
        System.out.println("Novices cannot meditate.");
    }

    @Override
    public void fight() {
        System.out.println("Novices cannot fight.");
    }

    @Override
    public void levelUp() {
        if (character.getExperience() >= 100) {
            character.setState(new IntermediateState(character));
            System.out.println("Leveled up to Intermediate!");
        }
    }
}
