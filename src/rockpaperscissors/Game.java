package rockpaperscissors;

public class Game {

    private int maxRounds;
    private int rounds = 0;

    private Player player1;
    private Player player2;

    public Game(int maxRounds, Player player1, Player player2) {
        this.maxRounds = maxRounds;
        this.player1 = player1;
        this.player2 = player2;
    }



    private void playRound() {

        Hand player1Hand = player1.chooseHand();
        Hand player2Hand = player2.chooseHand();

        System.out.println("\nNew round: \n");
        System.out.println(player1.getName() + " has " + player1.getVictories()+ " victories, now chooses " + player1Hand);
        System.out.println(player2.getName() + " has " + player2.getVictories()+ " victories, now chooses " + player2Hand);

        if (player1Hand == player2Hand) {
            playRound();
            return;
        }

        rounds++;

        Player winner = player1;

        switch (player1Hand) {

            case ROCK:
                if (player2Hand == Hand.PAPER) {
                    winner = player2;
                }
                break;

            case PAPER:

                if (player2Hand == Hand.SCISSORS) {
                    winner = player2;
                }
                break;

            case SCISSORS:
                if (player2Hand == Hand.ROCK) {
                    winner = player2;
                }
                break;
        }
        winner.win();

    }

    private void showResults() {

        System.out.println("\n=== Game Over ===\n");
        System.out.println(player1.getName() + " has " + player1.getVictories() + " victories");
        System.out.println(player2.getName() + " has " + player2.getVictories() + " victories");

        if (player1.getVictories() == player2.getVictories()) {
            System.out.println("\nThe game is tied. Thank you for playing!");
            return;
        }
        System.out.println("\nWinner is: " + (player1.getVictories() > player2.getVictories() ? player1.getName() : player2.getName()));
        System.out.println("\nThank you for playing!");
    }

    public void startGame() {

        while(rounds < maxRounds) {
            playRound();
        }
        showResults();
    }
}
