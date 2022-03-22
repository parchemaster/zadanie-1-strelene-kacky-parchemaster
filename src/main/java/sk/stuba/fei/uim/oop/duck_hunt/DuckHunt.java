package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.Lake;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.data.card.action.Aim;
import sk.stuba.fei.uim.oop.data.card.action.Shoot;
import sk.stuba.fei.uim.oop.data.card.action.WildBill;
import sk.stuba.fei.uim.oop.data.card.action.action.move.*;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.*;


public class DuckHunt  {
    private List<Player> players = new ArrayList<>();
    private List<ActionCard> actionDeck;
    private List<DuckDeck> duckDeck;
    private Board board;
    private int currentPlayer;
    private int roundCounter;

    public DuckHunt() {
        this.actionDeck = createActionCards();
        this.duckDeck = createDuckDeck();
        this.currentPlayer = currentPlayer;
        this.roundCounter = roundCounter;
    }

    public void startGame() {
        creatPlayersAndBoard();
        System.out.println("--- GAME STARTED ---");
        for (this.currentPlayer = 0; getNumberActivePlayers() > 1; this.incrementCounter()) {
            if (this.currentPlayer == 0) {
                System.out.println("--- ROUND " + (this.roundCounter / this.players.size() + 1) + " STARTS ---");
            }
            Player activePlayer = this.players.get(this.currentPlayer);
            if (!activePlayer.isActive()) {
                continue;
            }

            //TODO items.removeIf(item -> item.num == number);
            if (activePlayer.getDuckList().size() < 1) {
                System.out.println("Player " + activePlayer.getName() + " lost");
                activePlayer.setActive(false);
                actionDeck.addAll(activePlayer.getActionCards());
                //TODO карты проиграный игрок кладет в калоду?
                // TODO нужно переделать усдловие
                continue;
            }
            System.out.println("--- PLAYER " + activePlayer.getName() + " STARTS TURN ---");
            System.out.println("Player " + activePlayer.getName()
                    + " has: " + activePlayer.getDuckList().size()
                    + " ducks");
//            board.getDuckActiveCards().forEach(duck
//                    -> System.out.println((board.getDuckActiveCards().indexOf(duck) + 1)
//                    + ": " + board.printDuckInfo(board.getDuckActiveCards().indexOf(duck))));
            try {
                board.getDuckActiveCards().forEach(duck -> {
                    var index = board.getDuckActiveCards().indexOf(duck);
                    System.out.println((index + 1) + ": " + board.printDuckInfo(index));
                });
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Error");
            }
            activePlayer.activateActionCard(board);
        }
    }

    // TODO
    //  POZOR: Kartu musí zahrať aj v prípade, ak by musel zastreliť svoju kačku.
    //  Pokiaľ sa žiadna karta nedá logicky zahrať
    //  (hráč ma na ruke 3 karty Strieľaj ale nie je zamierené na žiadne políčko v rybníku),
    //  tak musí jednu kartu zahodiť na spodok balíčka akčných kariet , a vziať si z neho inú (v tomto kole hráč nehrá žiadnu kartu).

    private void incrementCounter() {
        this.currentPlayer++;
        this.currentPlayer %= this.players.size();
        this.roundCounter++;
    }

    private void creatPlayersAndBoard() {
        int numberOfPlayers = ZKlavesnice.readInt("Enter the number of players");
        for (int index = 0; index < numberOfPlayers; index++) {
            var newPlayer = new Player(ZKlavesnice.readString("Enter PLAYER " + (index + 1) + " name:"));
            while (newPlayer.getActionCards().size() < 3) {
                newPlayer.dealActionCards(actionDeck);
            }
            this.players.add(newPlayer);
            createPlayerDucks(newPlayer);
        }
        board = new Board(actionDeck, duckDeck, players);
        board.dealCards(6);
    }

    private void createPlayerDucks(Player player) {
        var ducks = new ArrayList<Duck>();
        for (int i = 0; i < 5; i++) {
            ducks.add(new Duck("Duck of player " + player.getName()));
        }
        player.getDuckList().addAll(ducks);
        duckDeck.addAll(ducks);
        Collections.shuffle(duckDeck);
        Collections.shuffle(duckDeck);
    }

    private int getNumberActivePlayers() {
        var sum = 0;
//        for (Player player : players) {
//            sum += player.isActive() ? 1 : 0;
//        }
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<ActionCard> getActionDeck() {
        return actionDeck;
    }

    public void setActionDeck(List<ActionCard> actionDeck) {
        this.actionDeck = actionDeck;
    }

    public List<DuckDeck> getDuckDeck() {
        return duckDeck;
    }

    public void setDuckDeck(List<DuckDeck> duckDeck) {
        this.duckDeck = duckDeck;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }
}
