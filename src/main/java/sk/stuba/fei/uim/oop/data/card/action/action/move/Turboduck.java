package sk.stuba.fei.uim.oop.data.card.action.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class Turboduck extends ActionCard {

    public Turboduck(String name) {
        super(name);
    }
    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to choose", 6);
//        if (index > 6 || index < 1) {
//            System.out.println("Wrong index, try again from choosing index");
//            action(player, board);
//            return;
//        }
        var chosenDuck = board.getDucksOnBoard().get(index-1);
        if (chosenDuck.getClass().equals(Lake.class)) {
            System.out.println("You have to choose duck exactly. Not water, try again from choosing index");
            action(player, board);
            return;
        }
        var duckOnDesk = board.getDucksOnBoard();
        swapDucks(chosenDuck, duckOnDesk);
        board.getActionDeck().add(new Turboduck("Turbo duck"));
    }

    private void swapDucks(DuckDeck chosenDuck, List<DuckDeck> ducksOnDesk) {
        for (int index = ducksOnDesk.indexOf(chosenDuck); index > 0; index --) {
            var nextDuck = ducksOnDesk.get(index - 1);
            ducksOnDesk.set(index, nextDuck);
        }
        ducksOnDesk.set(0, chosenDuck);
    }
}
