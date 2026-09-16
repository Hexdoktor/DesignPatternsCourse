import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter hero = new GameCharacter("He-Man");

        while (!hero.getLevelName().equals("Master")) {

            hero.printStatus();

            System.out.println("Available actions:");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.println("Choose action:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> hero.train();
                case 2 -> hero.meditate();
                case 3 -> hero.fight();
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Congratulations! You reached MASTER level. Game complete.");
    }
}
