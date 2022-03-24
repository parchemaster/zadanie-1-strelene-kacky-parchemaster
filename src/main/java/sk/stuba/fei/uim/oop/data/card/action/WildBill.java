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
        var index = ZKlavesnice.readInt("What do you want to target");
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again from choosing index");
            action(player, board);
            return;
        }
        var shotDuck = board.getDucksOnBoard().get(index-1);
        var ducksOnBoard = board.getDucksOnBoard();
        var duckDeck = board.getDuckDeck();
        var players = board.getPlayers();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        ducksOnBoard.remove(shotDuck);
        if (shotDuck instanceof Duck) removePlayerDuck(players, (Duck)shotDuck);
        board.dealCards(1);
        board.getAimField().set(index-1, false);
    }
}
