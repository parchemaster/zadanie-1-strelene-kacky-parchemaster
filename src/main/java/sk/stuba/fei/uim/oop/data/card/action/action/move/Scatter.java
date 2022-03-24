package sk.stuba.fei.uim.oop.data.card.action.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

import java.util.Collections;

public class Scatter extends ActionCard {

    public Scatter(String name) {
        super(name);
    }

    @Override
    public void action(Player player, Board board) {
        var duckOnDesk = board.getDucksOnBoard();
        board.getActionDeck().add(new Scatter("Scatter"));
        Collections.shuffle(duckOnDesk);
        Collections.shuffle(duckOnDesk);
    }
}
