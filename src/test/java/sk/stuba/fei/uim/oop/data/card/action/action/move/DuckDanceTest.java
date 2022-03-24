package sk.stuba.fei.uim.oop.data.card.action.action.move;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

import java.util.Collections;

public class DuckDanceTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());
    @Test
    public void action() {
        var ducksOnDesk = board.getDucksOnBoard();
        var duckDeck = board.getDuckDeck();
        duckDeck.addAll(ducksOnDesk);
        ducksOnDesk.removeAll(ducksOnDesk);
        Collections.shuffle(duckDeck);
        Collections.shuffle(duckDeck);
        for (int i = 0; i < 7; i++) {
            ducksOnDesk.add(duckDeck.get(0));
            duckDeck.remove(0);
        }
    }
}