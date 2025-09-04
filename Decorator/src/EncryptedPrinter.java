public class EncryptedPrinter implements Printer {

    private final Printer printer;
    private final int encryptionStep = 2;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String str) {
        String encryptedStr = encrypt(str);
        if (this.printer != null) {
            this.printer.print(encryptedStr);
        }
    }

    private String encrypt(String str) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : str.toCharArray()) {
            encrypted.append((char) (c + encryptionStep));
        }
        return encrypted.toString();
    }
}