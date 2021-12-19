package tn.esprit.models;

public class Player {
    private String name;
    private int score = 0;
    private Hand hand;

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static String scoreStatus(Player player , Player computer){
        return Math.max(player.getScore(), computer.getScore()) +" : " + Math.min(player.getScore(), computer.getScore()) + " for : " + (computer.getScore() > player.getScore() ? computer.getName() : player.getName());
    }
}
