public class ButtonA extends Button {
    private String text;

    public ButtonA(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("ButtonA: " + text);
    }
}