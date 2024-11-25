package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeTest {
    Game aGame;
    FakeRunGame fakeGame;
    FakePrint fakePrint;
    @BeforeEach
    public void setUp() {
        fakePrint = new FakePrint();
        aGame = new Game(fakePrint);
        fakeGame = new FakeRunGame();
        aGame.add("Chet");
    }

    @Test
    public void player_is_added() throws Exception {
        assertEquals(1, aGame.howManyPlayers());
    }
    @Test
    public void is_not_playable() throws Exception {
        assertFalse(aGame.isPlayable());
    }
    @Test
    public void is_playable() throws Exception {
        aGame.add("Test2");
        assertTrue(aGame.isPlayable());
    }

    @Test
    public void fake_game() throws Exception {
        boolean notAWinner;
        aGame.add("Pat");
        aGame.add("Sue");
        for(int i = 0; i < fakeGame.rollanswer.size(); i++) {
            aGame.roll(fakeGame.rolldice.get(i));

            if (fakeGame.rollanswer.get(i) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }
            if(!notAWinner) {break;}
        }
        assertEquals(fakeGame.printWanted, fakePrint.printlist);
    }
}
