public abstract class State {
    protected Character character;
    public State(Character character) {
        this.character = character;
    }
    public Character getCharacter() {
        return character;
    }
    public abstract void train();
    public abstract void meditate();
    public abstract void fight();
    public abstract void levelUp();
}