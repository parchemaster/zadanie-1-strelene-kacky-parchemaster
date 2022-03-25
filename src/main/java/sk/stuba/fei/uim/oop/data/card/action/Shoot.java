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
        var index = ZKlavesnice.readInt("What do you want to shoot", 6);
        if (!board.getAimField().get(index-1)) {
            System.out.println("Wrong index or duck has to be aimed at the first, try again from choosing action card");
            player.activateActionCard(board);
            return;
        }
        var ducksOnBoard = board.getDucksOnBoard();
        var shotDuck = board.getDucksOnBoard().get(index-1);
        var players = board.getPlayers();
        board.getActionDeck().add(new Shoot("Shoot"));
        if (shotDuck instanceof Duck) {
            removePlayerDuck(players, (Duck)shotDuck);
            ducksOnBoard.remove(shotDuck);
            board.dealCards(1);
        }
        board.getAimField().set(index-1, false);
    }
}
