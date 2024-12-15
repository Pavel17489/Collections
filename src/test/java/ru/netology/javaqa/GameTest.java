package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testPlayer1Win() {

        Player soler = new Player(56, "Солер", 230);
        Player faster = new Player(23, "Быстрый", 180);

        Game game = new Game();

        game.register(soler);
        game.register(faster);
        int actual = game.round("Солер","Быстрый");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testPlayer2Win() {

        Player soler = new Player(56, "Солер", 190);
        Player faster = new Player(23, "Быстрый", 180);

        Game game = new Game();

        game.register(soler);
        game.register(faster);
        int actual = game.round("Быстрый","Солер");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testDrawInTheGame() {

        Player soler = new Player(56, "Солер", 150);
        Player faster = new Player(23, "Быстрый", 150);

        Game game = new Game();

        game.register(soler);
        game.register(faster);
        int actual = game.round("Солер","Быстрый");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testPlayer1NotRegistered() {

        Player soler = new Player(56, "Солер", 150);

        Game game = new Game();

        game.register(soler);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Зеленый","Солер")
        );

    }

    @Test
    public void testPlayer2NotRegistered() {

        Player soler = new Player(56, "Солер", 150);

        Game game = new Game();

        game.register(soler);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Солер","Красный")
        );

    }
}