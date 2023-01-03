package rockpaperscissors;


public class Player {

    private String name;
    private int numberOfVictories = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVictories() {
        return numberOfVictories;
    }

    public void win() {
        numberOfVictories++;
    }

    public Hand chooseHand() {
        return Hand.values()[(int) (Math.random() * Hand.values().length)];
    }
}
