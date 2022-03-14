package sk.stuba.fei.uim.oop.data.card.action.move;


import org.junit.jupiter.api.Test;
import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

class TurboduckTest {

    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionCards(), duckHunt.getDuckDeck(), 2);


    @Test
    void action(Player player) {
        var index = ZKlavesnice.readInt("What do you want to target");
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action(player);
        }
        var chosenDuck = (Duck)board.getDuckActiveCards().get(index);
        var duckOnDesk = board.getDuckActiveCards();
        swapDucks(chosenDuck, duckOnDesk);
        //TODO проверить забираю ли я карты из колоды когда раздаю игрокам активити карты
        board.getActionActiveCards().add(new Turboduck("Turbo duck"));
    }

    @Test
    void swapDucks(Duck chosenDuck, List<DuckDeck> ducksOnDesk) {
        for (int index = ducksOnDesk.indexOf(chosenDuck); index > 0; index --) {
            var nextDuck = ducksOnDesk.get(index - 1);
            ducksOnDesk.set(index, nextDuck);
        }
        ducksOnDesk.set(0, chosenDuck);
    }
}