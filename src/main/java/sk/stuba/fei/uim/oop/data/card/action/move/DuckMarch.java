package sk.stuba.fei.uim.oop.data.card.action.move;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

public class DuckMarch extends ActionCard {
    private final String name;

    public DuckMarch(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void action(Player player, Board board) {
        //read one more
        board.getActionDeck().add(new DuckMarch("Duck March"));
        var firstDuckOnBoard = (Duck)board.getDuckActiveCards().get(0);
        var duckDeck = board.getDuckDeck();
        var ducksOnBoard = board.getDuckActiveCards();
        //TODO исправить, потому что утка вкладывается в начало калоды ?
        ducksOnBoard.remove(firstDuckOnBoard);
        ducksOnBoard.add(duckDeck.get(0));
        duckDeck.add(firstDuckOnBoard);
    }
}
