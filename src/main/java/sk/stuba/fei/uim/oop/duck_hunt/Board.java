package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;


import java.util.*;

public class Board {
    private final List<Boolean> aimField = new ArrayList<Boolean>(Arrays.asList(new Boolean[6]));
    private final List<DuckDeck> ducksOnBoard = new ArrayList<>();
    private final List<ActionCard> actionDeck;
    private List<DuckDeck> duckDeck;
    private final List<Player> players;


    public Board(List<ActionCard> actionDeck, List<DuckDeck> duckDeck, List<Player> players) {
        this.actionDeck = actionDeck;
        this.duckDeck = duckDeck;
        Collections.fill(aimField, Boolean.FALSE);
        this.players = players;
    }


    // flips the duck cards and puts them on the table
    public void dealCards(int count) {
        for (;count > 0; count --) {
            ducksOnBoard.add(duckDeck.get(0));
            duckDeck.remove(duckDeck.get(0));
        }
    }

    public List<Boolean> getAimField() {
        return aimField;
    }

    public String printDuckInfo(int index) {
        return ducksOnBoard.get(index).getName() + (aimField.get(index) ? " is aimed" : " isn't aimed");
    }

    public List<DuckDeck> getDucksOnBoard() {
        return ducksOnBoard;
    }


    public List<ActionCard> getActionDeck() {
        return actionDeck;
    }

    public List<DuckDeck> getDuckDeck() {
        return duckDeck;
    }

    public void setDuckDeck(List<DuckDeck> duckDeck) {
        this.duckDeck = duckDeck;
    }


    public List<Player> getPlayers() {
        return players;
    }

}
