package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Shoot extends ActionCard{

    public Shoot(String name) {
        super(name);
    }
    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to shoot");
        if (index > 6 || index < 1 || !board.getAimField().get(index-1)) {
            System.out.println("Wrong index or duck has to be aimed at the first, try again from choosing action card");
            player.activateActionCard(board);
            return;
        }
        var shotDuck = board.getDucksOnBoard().get(index-1);
        var ducksOnBoard = board.getDucksOnBoard();
        var duckDeck = board.getDuckDeck();
        var players = board.getPlayers();
        board.getActionDeck().add(new Shoot("Shoot"));
        ducksOnBoard.remove(shotDuck);
        if (shotDuck instanceof Duck) removePlayerDuck(players, (Duck)shotDuck);
        board.getAimField().set(index-1, false);
        ducksOnBoard.add(duckDeck.get(0));
        duckDeck.remove(0);
    }
}
