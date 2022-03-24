package sk.stuba.fei.uim.oop.data.card.action.action.move;


import org.junit.jupiter.api.Test;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;

import java.util.List;

class TurboduckTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());


    @Test
    void action() {
        var index = 3;
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action();
        }
        var chosenDuck = board.getDucksOnBoard().get(index);
        if (chosenDuck.getClass().equals(Lake.class)) {
            System.out.println("You have to choose duck exactly. Not water, try again");
            action();
        }
        var duckOnDesk = board.getDucksOnBoard();
        swapDucks();
        //TODO проверить забираю ли я карты из колоды когда раздаю игрокам активити карты
        board.getActionDeck().add((new Turboduck("Turbo duck")));
    }

    @Test
    void swapDucks() {
        DuckDeck chosenDuck = board.getDucksOnBoard().get(3);
        List<DuckDeck> ducksOnDesk = board.getDucksOnBoard();
        for (int index = ducksOnDesk.indexOf(chosenDuck); index > 0; index --) {
            var nextDuck = ducksOnDesk.get(index - 1);
            ducksOnDesk.set(index, nextDuck);
        }
        ducksOnDesk.set(0, chosenDuck);
    }
}