public class TextFieldA extends TextField {
    private String text;

    public TextFieldA(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("TextFieldA: " + text);
    }
}