package sk.stuba.fei.uim.oop.data.card.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

import java.util.Collections;

public class Scatter extends ActionCard {

    private final String name;

    public Scatter(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
        var duckOnDesk = board.getDuckActiveCards();
        Collections.shuffle(duckOnDesk);
        Collections.shuffle(duckOnDesk);
    }
}
