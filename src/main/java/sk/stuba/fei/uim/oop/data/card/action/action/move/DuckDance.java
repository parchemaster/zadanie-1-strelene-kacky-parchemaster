package sk.stuba.fei.uim.oop.data.card.action.action.move;

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
        // TODO there is an error
        var ducksOnDesk = board.getDuckActiveCards();
        var duckDeck = board.getDuckDeck();
        duckDeck.addAll(ducksOnDesk);
        ducksOnDesk.removeAll(ducksOnDesk);
        board.getActionDeck().add(new DuckDance("Duck dance"));
        Collections.shuffle(duckDeck);
        Collections.shuffle(duckDeck);
        for (int i = 0; i < 6; i++) {
            ducksOnDesk.add(duckDeck.get(0));
            duckDeck.remove(0);
        }
    }
}
