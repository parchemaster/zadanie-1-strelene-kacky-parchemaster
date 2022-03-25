package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBill extends ActionCard{

    public WildBill(String name) {
        super(name);
    }
    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to target", 6);
        var shotDuck = board.getDucksOnBoard().get(index-1);
        var ducksOnBoard = board.getDucksOnBoard();
        var players = board.getPlayers();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        if (shotDuck instanceof Duck) {
            ducksOnBoard.remove(shotDuck);
            removePlayerDuck(players, (Duck) shotDuck);
            board.dealCards(1);

        }
        board.getAimField().set(index-1, false);
    }
}
