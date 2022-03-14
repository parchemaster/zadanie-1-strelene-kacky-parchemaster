package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Shoot extends ActionCard{
    private final String name;

    public Shoot(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to shoot");
        var duck = (Duck)board.getDuckActiveCards().get(index);
        if (index > 6 || index < 1 && !duck.getIsGunpoint()) {
            System.out.println("Wrong index or duck has to be aimed at the first, try again");
            action(player, board);
        }
        board.getActionDeck().add(new Shoot("Shoot"));
        board.getDuckActiveCards().remove(duck);
    }
}
