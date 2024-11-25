package com.adaptionsoft.games.trivia;


import com.adaptionsoft.games.uglytrivia.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
    public void enter_to_penalty() throws Exception {
        aGame.add("Test2");
        aGame.roll(2);
        aGame.wrongAnswer();
        assertEquals("Chet was sent to the penalty box",fakePrint.printlist.get(fakePrint.printlist.size()-1));
    }

    @Test
    public void test_roll(){
        aGame.add("Test2");
        aGame.roll(2);
        assertEquals("Sports Question 0",fakePrint.printlist.get(fakePrint.printlist.size()-1));
        assertEquals("The category is Sports",fakePrint.printlist.get(fakePrint.printlist.size()-2));
        assertEquals("Chet's new location is 2",fakePrint.printlist.get(fakePrint.printlist.size()-3));
    }

    @Test
    public void fake_game_seeded() throws Exception {
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

    @Test
    public void end_with_6gold() throws Exception {
        aGame.add("Pat");
        aGame.add("Sue");
        boolean notAWinner;
        Random rand = new Random();


        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }



        } while (notAWinner);
        assertTrue(fakePrint.printlist.get(fakePrint.printlist.size()-1).contains(" now has 6 Gold Coins."));
    }
}
