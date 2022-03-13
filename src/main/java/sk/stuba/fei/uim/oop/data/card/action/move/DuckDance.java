package sk.stuba.fei.uim.oop.data.card.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

public class DuckDance extends ActionCard {

    private final String name;

    public DuckDance(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void action(Player player, Board board) {

    }
}
