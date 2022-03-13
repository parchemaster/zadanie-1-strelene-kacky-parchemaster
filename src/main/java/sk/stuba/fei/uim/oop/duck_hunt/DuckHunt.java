package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.data.card.action.Aim;
import sk.stuba.fei.uim.oop.data.card.action.Shoot;
import sk.stuba.fei.uim.oop.data.card.action.WildBill;
import sk.stuba.fei.uim.oop.data.card.action.move.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.*;


public class DuckHunt  {
    private List<Player> players = new ArrayList<>();
    private List<ActionCard> actionCards;
    private List<DuckDeck> duckDeck;
    private Board board;
    private int currentPlayer;
    private int roundCounter;

    public DuckHunt() {
        System.out.println("Duck hunt is starting");
        int numberOfPlayers = ZKlavesnice.readInt("Enter the number of players");
        creatPlayer(numberOfPlayers);
        this.actionCards = createActionCards();
        this.duckDeck = createDuckDeck();
        createBord(numberOfPlayers);
        startGame();
        this.currentPlayer = currentPlayer;
        this.roundCounter = roundCounter;
    }

    //TODO go on here
    private void startGame() {
        System.out.println("--- GAME STARTED ---");
        for (this.currentPlayer = 0; getNumberActivePlayers() > 1; this.incrementCounter()) {
            if (this.currentPlayer == 0) {
                System.out.println("--- ROUND " + (this.roundCounter / this.players.size() + 1) + " STARTS ---");
            }
            Player activePlayer = this.players.get(this.currentPlayer);
            if (!activePlayer.isActive()) {
                continue;
            }
            System.out.println("--- PLAYER " + activePlayer.getName() + " STARTS TURN ---");
            System.out.println("Player has: " + activePlayer.getDuckList().size() + " ducks");
            while (activePlayer.getActionCards().size() < 3) {
                activePlayer.dealCard(actionCards);
            }
            board.getDuckActiveCards().forEach(duck -> System.out.println((board.getDuckActiveCards().indexOf(duck) + 1) + ": " + duck.getName()));
            activePlayer.startAction(board);

        }
    }

    private void createBord(int playersCount) {
        board = new Board(actionCards, duckDeck, playersCount);
    }

    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.size();
        this.roundCounter++;
    }

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

    private List<DuckDeck> createDuckDeck() {
        var cards = new ArrayList<DuckDeck>();
        cards.add(new Lake("Water"));
        cards.add(new Lake("Water"));
        cards.add(new Lake("Water"));
        cards.add(new Lake("Water"));
        cards.add(new Lake("Water"));
        return  cards;
    }
    
    private List<ActionCard> createActionCards() {
        var cards = new ArrayList<ActionCard>();
        cards.add(new DuckMarch("Duck March"));
        cards.add(new DuckMarch("Duck March"));
        cards.add(new DuckMarch("Duck March"));
        cards.add(new DuckMarch("Duck March"));
        cards.add(new DuckMarch("Duck March"));
        cards.add(new DuckMarch("Duck March"));

        cards.add(new Turboduck("Turboduck"));

        cards.add(new Scatter("Scatter"));
        cards.add(new Scatter("Scatter"));

        cards.add(new DuckDance("Duck Dance"));

        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));
        cards.add(new Aim("Aim"));

        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));
        cards.add(new Shoot("Shoot"));

        cards.add(new WildBill("Wild Bill"));
        cards.add(new WildBill("Wild Bill"));

        Collections.shuffle(cards);
        Collections.shuffle(cards);
        return cards;
    }
}
