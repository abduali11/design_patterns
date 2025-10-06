
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recommendation recommendation = new Recommendation("Young Adults");

        recommendation.addBook(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997));
        recommendation.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));

        System.out.println("Original Recommendation:");
        System.out.println(recommendation);

        System.out.println("\nCloning the recommendation...");
        Recommendation clonedRecommendation = recommendation.clone();
        clonedRecommendation.setTargetAudience("Adults");
        clonedRecommendation.addBook(new Book("George Orwell", "1984", "Dystopian", 1949));

        System.out.println("Cloned Recommendation:");
        System.out.println(clonedRecommendation);

        System.out.println("\nOriginal Recommendation after cloning:");
        System.out.println(recommendation);
    }
}