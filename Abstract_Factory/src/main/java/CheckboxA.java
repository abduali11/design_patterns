public class CheckboxA extends CheckBox {
    private String text;

    public CheckboxA(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("CheckboxA: " + text);
    }
}