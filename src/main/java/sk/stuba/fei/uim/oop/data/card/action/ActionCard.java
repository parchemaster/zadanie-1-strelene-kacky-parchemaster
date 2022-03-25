package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

import java.util.List;

public abstract class ActionCard {
    private final String name;

    public ActionCard(String name) {
        this.name = name;
    }

    public abstract void action(Player player, Board board);

    public String getName() {
        return name;
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
