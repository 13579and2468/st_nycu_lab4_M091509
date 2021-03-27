import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    public static Stream<Arguments> all_win_cases_parameters(){
        return Stream.of(
                arguments(new String("rock"),new String("scissors")),
                arguments(new String("scissors"),new String("paper")),
                arguments(new String("paper"),new String("rock"))
        );
    }

    public static Stream<Arguments> all_lose_cases_parameters(){
        return Stream.of(
                arguments(new String("scissors"),new String("rock")),
                arguments(new String("paper"),new String("scissors")),
                arguments(new String("rock"),new String("paper"))
        );
    }

    public static Stream<Arguments> all_draw_cases_parameters(){
        return Stream.of(
                arguments(new String("rock"),new String("rock")),
                arguments(new String("scissors"),new String("scissors")),
                arguments(new String("paper"),new String("paper"))
        );
    }

    public static Stream<Arguments> invalid_cases_parameters(){
        return Stream.of(
                arguments(new String(" ")),
                arguments(new String("scissor")),
                arguments(new String(""))
        );
    }

    @ParameterizedTest(name = "#{index} Test with Argument={0},{1}")
    @MethodSource("all_win_cases_parameters")
    void all_win_cases(String choice1,String choice2) {
        game.player_input(0,choice1);
        game.player_input(1,choice2);
        assertEquals(game.who_win(),"Player 2 win!");
    }

    @ParameterizedTest(name = "#{index} Test with Argument={0},{1}")
    @MethodSource("all_lose_cases_parameters")
    void all_lose_cases(String choice1,String choice2) {
        game.player_input(0,choice1);
        game.player_input(1,choice2);
        assertEquals(game.who_win(),"Player 2 win!");
    }

    @ParameterizedTest(name = "#{index} Test with Argument={0},{1}")
    @MethodSource("all_draw_cases_parameters")
    void all_draw_cases(String choice1,String choice2) {
        game.player_input(0,choice1);
        game.player_input(1,choice2);
        assertEquals(game.who_win(),"Draw!");
    }

    @ParameterizedTest(name = "#{index} Test with Argument={0}")
    @MethodSource("invalid_cases_parameters")
    void invalid_cases(String choice1) {
        assertThrows(IllegalArgumentException.class,() -> { game.player_input(0,choice1); });
    }

    @Test
    void invalid_player_cases() {
        assertThrows(IllegalArgumentException.class,() -> { game.player_input(-1,"rock"); });
        assertThrows(IllegalArgumentException.class,() -> { game.player_input(3,"rock"); });
    }

}