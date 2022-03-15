package sk.stuba.fei.uim.oop.data.card.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.data.card.action.WildBill;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class Turboduck extends ActionCard {

    private final String name;

    public Turboduck(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
        //TODO create a test and test this shit, I'm not sure whether is works
        var index = ZKlavesnice.readInt("What do you want to target");
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action(player, board);
        }
        //player has to choose exactly duck??
        var chosenDuck = (Duck)board.getDuckActiveCards().get(index);
        var duckOnDesk = board.getDuckActiveCards();
        swapDucks(chosenDuck, duckOnDesk);
        //TODO проверить забираю ли я карты из колоды когда раздаю игрокам активити карты
        board.getActionDeck().add(new Turboduck("Turbo duck"));
        //TODO check if I remove action cards from players
        //TODO вероятно нужно заменить буул (прицел) у уток на булл (прицел) на поля
    }

    public void swapDucks(Duck chosenDuck, List<DuckDeck> ducksOnDesk) {
        for (int index = ducksOnDesk.indexOf(chosenDuck); index > 0; index --) {
            var nextDuck = ducksOnDesk.get(index - 1);
            ducksOnDesk.set(index, nextDuck);
        }
        ducksOnDesk.set(0, chosenDuck);
    }
}
