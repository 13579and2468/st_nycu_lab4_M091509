import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner input_scan = new Scanner(System.in);
        System.out.println("=== Welcome to Rock-Paper_Scissors game ===");
        System.out.println("Enter Player 1 choice (rock, paper or scissors):");
        game.player_input(0,input_scan.nextLine());
        System.out.println("Enter Player 2 choice (rock, paper or scissors):");
        game.player_input(1,input_scan.nextLine());
        System.out.println(game.who_win());
        System.exit(0);
    }
}
