package sk.stuba.fei.uim.oop.data.card.action.action;

import org.junit.Test;
import sk.stuba.fei.uim.oop.data.card.action.WildBill;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

public class WildBillTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());
    @Test
    public void action() {
        var index = 3;
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action();
        }
        var duck = board.getDucksOnBoard().get(index);
        var ducksOnDesk = board.getDucksOnBoard();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        ducksOnDesk.remove(duck);
        board.getAimField().set(index, false);
        board.getDucksOnBoard().add(board.getDuckDeck().get(0));
    }
}