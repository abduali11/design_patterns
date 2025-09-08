import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter character name: ");
        String name = scanner.nextLine();
        Character character = new Character(name);
        character.play();
    }
}
