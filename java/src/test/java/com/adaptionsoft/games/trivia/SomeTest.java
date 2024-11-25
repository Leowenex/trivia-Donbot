package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeTest {
    Game aGame;
    @BeforeEach
    public void setUp() {
        aGame = new Game();
    }

    @Test
    public void player_is_added() throws Exception {
        aGame.add("Test");
        assertEquals(1, aGame.howManyPlayers());
    }
    @Test
    public void is_not_playable() throws Exception {
        aGame.add("Test");
        assertFalse(aGame.isPlayable());
    }
    @Test
    public void is_playable() throws Exception {
        aGame.add("Test");
        aGame.add("Test2");
        assertTrue(aGame.isPlayable());
    }
}
