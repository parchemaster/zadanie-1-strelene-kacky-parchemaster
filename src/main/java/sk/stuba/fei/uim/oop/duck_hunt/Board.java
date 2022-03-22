package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;


import java.util.*;

public class Board  {
//    private List<Boolean> aimField = new ArrayList<>();
    private List<Boolean> aimField = new ArrayList<Boolean>(Arrays.asList(new Boolean[6]));
    private List<DuckDeck> duckActiveCards = new ArrayList<>();
    private List<ActionCard> actionDeck;
    private List<DuckDeck> duckDeck;
    private List<Player> players;


    public Board(List<ActionCard> actionDeck, List<DuckDeck> duckDeck, List<Player> players) {
        this.actionDeck = actionDeck;
        this.duckDeck = duckDeck;
        Collections.fill(aimField, Boolean.FALSE);
        this.players = players;
    }


    // переворачивает карты уток и кладе их на стол
    public void dealCards(int count) {
        for (; duckActiveCards.size() < count;) {
            duckActiveCards.add(duckDeck.get(0));
            duckDeck.remove(duckDeck.get(0));
        }
    }

    public List<Boolean> getAimField() {
        return aimField;
    }

    public void setAimField(List<Boolean> aimField) {
        this.aimField = aimField;
    }

    public String printDuckInfo(int index) {
        return duckActiveCards.get(index).getName() + (aimField.get(index) ? " is aimed" : " isn't aimed");
    }

    public List<DuckDeck> getDuckActiveCards() {
        return duckActiveCards;
    }

    public void setDuckActiveCards(List<DuckDeck> duckActiveCards) {
        this.duckActiveCards = duckActiveCards;
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


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
