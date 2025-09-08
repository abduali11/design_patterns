public class CheckboxB extends CheckBox {
    private String text;

    public CheckboxB(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("CheckboxB in a different style: " + text);
    }
}