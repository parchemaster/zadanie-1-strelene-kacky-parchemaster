package sk.stuba.fei.uim.oop.data.card.action.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

import java.util.Collections;

public class DuckDance extends ActionCard {

    public DuckDance(String name) {
        super(name);
    }

    @Override
    public void action(Player player, Board board) {
        var ducksOnDesk = board.getDucksOnBoard();
        var duckDeck = board.getDuckDeck();
        duckDeck.addAll(ducksOnDesk);
        board.getDucksOnBoard().removeAll(ducksOnDesk);
        board.getActionDeck().add(new DuckDance("Duck dance"));
        Collections.shuffle(duckDeck);
        Collections.shuffle(duckDeck);
        if (duckDeck.size() > 5) {
            board.dealCards(6);
        }
        else {
            board.dealCards(duckDeck.size());
        }
    }
}
