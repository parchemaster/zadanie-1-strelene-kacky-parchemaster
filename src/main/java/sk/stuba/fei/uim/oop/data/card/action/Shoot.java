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
        var duck = board.getDuckActiveCards().get(index-1);
        if (index > 6 || index < 1 || !board.getAimField().get(index-1)) {
            System.out.println("Wrong index or duck has to be aimed at the first, try again from choosing action card");
            player.activateActionCard(board);
            return;
        }
        board.getActionDeck().add(new Shoot("Shoot"));
        board.getDuckActiveCards().remove(duck);
        board.getAimField().set(index-1, false);
        board.getDuckActiveCards().add(board.getDuckDeck().get(0));
        //TODO логика уменьшени утаки у игрока после подстрела определеной утки, не продуманна
    }
}
