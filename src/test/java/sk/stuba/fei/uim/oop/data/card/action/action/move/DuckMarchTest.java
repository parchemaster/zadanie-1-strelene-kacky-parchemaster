package sk.stuba.fei.uim.oop.data.card.action.action.move;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

public class DuckMarchTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());
    @Test
    public void action() {
        board.getActionDeck().add(new DuckMarch("Duck March"));
        var firstDuckOnBoard = board.getDuckActiveCards().get(0);
        var duckDeck = board.getDuckDeck();
        var ducksOnBoard = board.getDuckActiveCards();
        ducksOnBoard.remove(firstDuckOnBoard);
        ducksOnBoard.add(duckDeck.get(0));
        duckDeck.add(firstDuckOnBoard);
    }
}