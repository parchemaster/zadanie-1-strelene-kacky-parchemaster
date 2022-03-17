package sk.stuba.fei.uim.oop.data.card.action;

import org.junit.Test;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

public class ShootTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), 2);

    @Test
    public void action() {
        var index = 3;
        var duck = board.getDuckActiveCards().get(index);
        if (index > 6 || index < 1 && !board.getAimField().get(index)) {
            System.out.println("Wrong index or duck has to be aimed at the first, try again");
            action();
        }
        board.getActionDeck().add(new Shoot("Shoot"));
        board.getDuckActiveCards().remove(duck);
        board.getAimField().set(index, false);
        board.getDuckActiveCards().add(board.getDuckDeck().get(0));
    }
}