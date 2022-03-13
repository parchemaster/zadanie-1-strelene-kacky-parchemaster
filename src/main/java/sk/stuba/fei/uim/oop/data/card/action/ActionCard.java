package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

public abstract class ActionCard {
    private final String name;
//    protected final String name;

    public ActionCard(String name) {
        this.name = name;
    }

    public abstract void action(Player player, Board board);

    public String getName() {
        return name;
    }
}
