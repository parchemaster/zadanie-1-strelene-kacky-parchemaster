package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.data.card.action.Aim;
import sk.stuba.fei.uim.oop.data.card.action.Shoot;
import sk.stuba.fei.uim.oop.data.card.action.WildBill;
import sk.stuba.fei.uim.oop.data.card.move.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.List;


public class DuckHunt {
    private List<Player> players;
    private final ActionCard[] actionCards;
    private final DuckMove[] duckMovesCards;
    private int currentPlayer;
    private int roundCounter;

    public DuckHunt() {
        System.out.println("Duck hunt is starting");
        int numberOfPlayers = ZKlavesnice.readInt("Enter the number of players");
        creatPlayer(numberOfPlayers);
        this.actionCards = createActionCards();
        this.duckMovesCards = createDuckMovesCards();
        this.currentPlayer = currentPlayer;
        this.roundCounter = roundCounter;
    }

    //TODO go on here
    private void startGame() {
        System.out.println("--- GAME STARTED ---");
        for (this.currentPlayer = 0; getNumberActivePlayers() > 1; this.incrementCounter()) {
            if (this.currentPlayer == 0) {
                System.out.println("--- ROUND " + (this.roundCounter / this.players.length + 1) + " STARTS ---");
            }
            Player activePlayer = this.players[this.currentPlayer];
            if (!activePlayer.isActive()) {
                continue;
            }
            System.out.println("--- PLAYER " + activePlayer.getName() + " STARTS TURN ---");
            System.out.println("Players money: " + activePlayer.getMoney());
            if (activePlayer.inPrison()) {
                activePlayer.decrementPrison();
                endTurn(activePlayer);
                continue;
            }
            this.board[activePlayer.throwDice(this.board.length)].activate(activePlayer);
            endTurn(activePlayer);
        }
    }
    //TODO go on here
//    private void roundCounter()

    private void creatPlayer(int numberOfPlayers) {
        for (int index = 0; index < numberOfPlayers; index++) {
            this.players.add(new Player(ZKlavesnice.readString("Enter PLAYER " + (index + 1) + " name:")));
        }
    }

    private int getNumberActivePlayers() {
        var sum = 0;
        for (Player player : players) {
            sum += player.isActive() ? 1 : 0;
        }
        sum += players.stream().mapToInt(player -> player.isActive() ? 1 : 0).sum();
        return sum;
    }

    private DuckMove[] createDuckMovesCards() {
        var cards = new DuckMove[] {
                new DuckMarch(),
                new DuckMarch(),
                new DuckMarch(),
                new DuckMarch(),
                new DuckMarch(),
                new DuckMarch(),

                new Turboduck(),

                new Scatter(),
                new Scatter(),

                new DuckDance()
        };
        return cards;
    }
    
    private ActionCard[] createActionCards() {
        var cards = new ActionCard[] {
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),
                new Aim(),

                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),
                new Shoot(),

                new WildBill(),
                new WildBill(),
        };
        return cards;
    }
}
