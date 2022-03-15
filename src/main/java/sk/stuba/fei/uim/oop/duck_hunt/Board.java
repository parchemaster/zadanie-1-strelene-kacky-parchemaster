package sk.stuba.fei.uim.oop.duck_hunt;

import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;


import java.util.*;

public class Board  {
//    private List<Boolean> aimField = new ArrayList<>();
    List<Boolean> aimField = new ArrayList<Boolean>(Arrays.asList(new Boolean[6]));
    private List<DuckDeck> duckActiveCards = new ArrayList<>();
    private List<ActionCard> actionDeck;
    private List<DuckDeck> duckDeck;
    private Random random = new Random();


    public Board(List<ActionCard> actionDeck, List<DuckDeck> duckDeck, int playersCount) {
        this.actionDeck = actionDeck;
        this.duckDeck = duckDeck;
        Collections.fill(aimField, Boolean.FALSE);
        addDucksToDeck(playersCount);
        dealCards(6);
    }


    public void dealCards(int count) {
        for (; duckActiveCards.size() < count;) {
            duckActiveCards.add(duckDeck.get(0));
            duckDeck.remove(duckDeck.get(0));
        }
    }

    private void addDucksToDeck(int playersCount) {
        for (int index = 0; index < playersCount; index ++) {
            for (int countDuck = 0; countDuck < 5; countDuck ++) {
                duckDeck.add(new Duck("Duck of player " + (index + 1)));
            }
        }
        Collections.shuffle(duckDeck);
        Collections.shuffle(duckDeck);
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


}
