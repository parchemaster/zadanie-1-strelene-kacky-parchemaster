package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBill extends ActionCard{
    private final String name;

    public WildBill(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
//        System.out.println("starts wildBill");
        var index = ZKlavesnice.readInt("What do you want to target");
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again from choosing index");
            action(player, board);
            return;
        }
        var duck = board.getDuckActiveCards().get(index-1);
        var ducksOnDesk = board.getDuckActiveCards();
        var duckDeck = board.getDuckDeck();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        ducksOnDesk.remove(duck);
        ducksOnDesk.add(duckDeck.get(0));
        duckDeck.remove(0);
        board.getAimField().set(index-1, false);
        //TODO проверить забираю ли я карты из колоды когда раздаю игрокам активити карты

    }
}
