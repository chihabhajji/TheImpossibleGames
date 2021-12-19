package tn.esprit.games;

import tn.esprit.models.Hand;
import tn.esprit.models.Player;

import java.util.Optional;
import java.util.Scanner;

public class RockPaperScissors implements Runnable{
    private static final Scanner sc = new Scanner(System.in);
    private final Player player;
    private final Player computer;

    @Override
    public void run() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        String choice = "";
        do {
            System.out.println("Choose your hand: (r)ock, (p)aper, (s)cissors , !q to quit");
            System.out.println("Enter your choice: ");
            choice = sc.nextLine();
            if(choice.equals("!q")){
                System.out.println("Goodbye!");
            } else {
                Optional<Hand> playerChoice = stringToHand(choice);
                if(playerChoice.isPresent()){
                    player.setHand(stringToHand(choice).get());
                    computer.setHand(makeItImpossible());
                    System.out.println(player.getName() + " plays " + player.getHand());
                    System.out.println(computer.getName() + " plays " + computer.getHand());
                    winner().addScore(1);
                    System.out.println(winner().getName() + " wins!" + " Score : " + Player.scoreStatus(player,computer));
                } else {
                    System.out.println("Invalid choice!");
                }
            }
        } while (!choice.equals("!q"));
        System.out.println("Goodbye! LOSER!");
    }
    private Player winner(){
        return switch (player.getHand()) {
            case ROCK -> computer.getHand() == Hand.SCISSORS ? player : computer;
            case PAPER -> computer.getHand() == Hand.ROCK ? player : computer;
            case SCISSORS -> computer.getHand() == Hand.PAPER ? player : computer;
        };
    }
    private Optional<Hand> stringToHand(String choice){
        return switch (choice) {
            case "r" -> Optional.of(Hand.ROCK);
            case "p" -> Optional.of(Hand.PAPER);
            case "s" -> Optional.of(Hand.SCISSORS);
            default -> Optional.empty();
        };
    }
    private Hand makeItImpossible(){
        return switch (player.getHand()) {
            case ROCK -> Hand.PAPER;
            case PAPER -> Hand.SCISSORS;
            case SCISSORS -> Hand.ROCK;
        };
    }
    public RockPaperScissors(Player player, Player computer){
        this.player = player;
        this.computer = computer;
    }
}
