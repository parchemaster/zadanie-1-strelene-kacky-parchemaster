package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Aim extends ActionCard{

    private final String name;

    public Aim(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to target");
        var duck = (Duck)board.getDuckActiveCards().get(index);
        if (index > 6 || index < 1 && !duck.getIsGunpoint()) {
            System.out.println("Wrong index or duck is already aimed, try again");
            action(player, board);
        }
        board.getActionDeck().add(new Aim("Aim"));
        duck.setGunpoint(true);
    }
}
