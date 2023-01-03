package rockpaperscissors;


public class Main {

    public static void main(String[] args) {

        Game game = new Game(10, new Player("Player One"), new Player("Player Two"));
        game.startGame();
    }
}
