package sk.stuba.fei.uim.oop.data.card.action.action.move;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

import java.util.Collections;

public class ScatterTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());
    @Test
    public void action() {
        var duckOnDesk = board.getDucksOnBoard();
        Collections.shuffle(duckOnDesk);
        Collections.shuffle(duckOnDesk);
    }
}