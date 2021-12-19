package tn.esprit;

import tn.esprit.games.RockPaperScissors;
import tn.esprit.models.Player;

import java.util.Scanner;

public class Main {
    private static final Player player = new Player();
    private static final Player computer = new Player();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the impossible games!");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + "!");
        player.setName(name);
        computer.setName("Player 2");
        System.out.println("Welcome to the Impossible Game!");
        System.out.println("You will be playing against the impossible to beat computer.");
        System.out.println("Press !q to quit anytime.");
        System.out.println("Let's begin!");
        int choice = 0;
        do{
            System.out.println("Which game do you want to play?");
            System.out.println("1. Guess the number");
            System.out.println("2. Rock Paper Scissors");
            System.out.println("3. Tic Tac Toe");
            System.out.println("4. Hangman");
            System.out.println("5. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1, 3, 4 -> System.out.println("OK");
                case 2 -> new RockPaperScissors(player,computer).run();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        }while (choice != 5);
    }
}
