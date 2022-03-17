package sk.stuba.fei.uim.oop.data.card.action;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

public class WildBillTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), 2);
    @Test
    public void action() {
        var index = 3;
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action();
        }
        var duck = board.getDuckActiveCards().get(index);
        var ducksOnDesk = board.getDuckActiveCards();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        ducksOnDesk.remove(duck);
        board.getAimField().set(index, false);
        board.getDuckActiveCards().add(board.getDuckDeck().get(0));
    }
}