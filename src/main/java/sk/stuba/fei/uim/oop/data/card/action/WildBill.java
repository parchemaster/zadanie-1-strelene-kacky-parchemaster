package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
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
        var duck = (Duck)board.getDuckActiveCards().get(index);
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again");
            action(player, board);
        }
        board.getActionDeck().add(new WildBill("Wild Bill"));
        //TODO проверить забираю ли я карты из колоды когда раздаю игрокам активити карты
        duck.setGunpoint(true);
    }
}
