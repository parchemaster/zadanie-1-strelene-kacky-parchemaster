package sk.stuba.fei.uim.oop.data.card.action.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

public class DuckMarch extends ActionCard {

    public DuckMarch(String name) {
        super(name);
    }

    @Override
    public void action(Player player, Board board) {
        board.getActionDeck().add(new DuckMarch("Duck March"));
        var duckDeck = board.getDuckDeck();
        var ducksOnBoard = board.getDucksOnBoard();
        duckDeck.add(board.getDucksOnBoard().get(0));
        ducksOnBoard.remove(0);
        board.dealCards(1);
    }
}
