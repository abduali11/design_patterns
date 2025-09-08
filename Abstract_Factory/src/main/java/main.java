public class main {
    public static void main(String[] args) {
        UIFactory factory = new AFactory();


        Button button = factory.createButton("ButtonA");
        CheckBox checkBox = factory.createCheckBox("CheckBoxA");
        TextField textField = factory.createTextField("TextFieldA");

        button.display();
        checkBox.display();
        textField.display();
    }
}
