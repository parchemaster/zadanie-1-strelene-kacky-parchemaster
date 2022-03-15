package sk.stuba.fei.uim.oop.data.card.action;

import org.junit.Test;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import static org.junit.Assert.*;

public class AimTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionCards(), duckHunt.getDuckDeck(), 2);
    @Test
    public void action() {
        var index = 3;
        if (index > 6 || index < 1 && board.getAimField().get(index)) {
            System.out.println("Wrong index or duck is already aimed, try again");
            action();
        }
        board.getActionDeck().add(new Aim("Aim"));
        board.getAimField().set(index, true);
    }
}