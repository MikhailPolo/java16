
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.Player;
import ru.netology.NotFoundException;

public class GameTest {

    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 90);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldWinSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 110);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public  void shouldNotWinPlayaer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 100);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNorRegisterFistPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 150);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Player3", "Player1");
        });
    }
    @Test
    public void shouldNorRegisterSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 100);
        Player player2 = new Player(2, "Player2", 150);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round("Player1", "Player3");
        });
    }
}