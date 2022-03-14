package sk.stuba.fei.uim.oop.data.card.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

import java.util.Collections;

public class DuckDance extends ActionCard {

    private final String name;

    public DuckDance(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void action(Player player, Board board) {
        var duckOnDesk = board.getDuckActiveCards();
        var duckDeck = board.getDuckDeck();
        duckDeck.addAll(duckOnDesk);
        duckOnDesk.removeAll(duckOnDesk);
        Collections.shuffle(duckOnDesk);
        Collections.shuffle(duckOnDesk);
        for (int i = 0; i < 7; i++) {
            duckOnDesk.add(duckDeck.get(0));
            duckDeck.remove(0);
        }
    }
}
