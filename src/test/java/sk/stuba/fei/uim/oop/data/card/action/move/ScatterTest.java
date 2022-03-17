package sk.stuba.fei.uim.oop.data.card.action.move;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

import java.util.Collections;

public class ScatterTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), 2);
    @Test
    public void action() {
        var duckOnDesk = board.getDuckActiveCards();
        Collections.shuffle(duckOnDesk);
        Collections.shuffle(duckOnDesk);
    }
}