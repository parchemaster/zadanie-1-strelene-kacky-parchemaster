package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;

public class WildBill extends ActionCard{
    private final String name;

    public WildBill(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
        var index = ZKlavesnice.readInt("What do you want to target");
        if (index > 6 || index < 1) {
            System.out.println("Wrong index, try again from choosing index");
            action(player, board);
            return;
        }
        var shotDuck = board.getDuckActiveCards().get(index-1);
        var ducksOnDesk = board.getDuckActiveCards();
        var duckDeck = board.getDuckDeck();
        var players = board.getPlayers();
        board.getActionDeck().add(new WildBill("Wild Bill"));
        ducksOnDesk.remove(shotDuck);
        if (shotDuck instanceof Duck) removePlayerDuck(players, (Duck)shotDuck);
        ducksOnDesk.add(duckDeck.get(0));
        duckDeck.remove(0);
        board.getAimField().set(index-1, false);
    }

    public void removePlayerDuck(List<Player> players, Duck duck) {
        for (var player : players) {
            if (player.getDuckList().contains(duck)) {
                player.getDuckList().remove(duck);
                break;
            }
        }
    }
}
