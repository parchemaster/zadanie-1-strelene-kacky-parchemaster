package sk.stuba.fei.uim.oop.data;

import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private List<Duck> duckList;
    private List<ActionCard> actionCards;
    private boolean isActive;
    private Random random = new Random();

    public Player(String name) {
        this.name = name;
        this.isActive = true;
        duckList = createDucks();
        actionCards = new ArrayList<>();
    }



    //player gets action card
    public void dealActionCards(List<ActionCard> actionDeck) {
        while (this.getActionCards().size() < 3) {
            getActionCards().add(actionDeck.get(0));
            actionDeck.remove(0);
        }
//        System.out.println("Player " + getName() + " got new card");
    }

    public void activateActionCard(Board board) {
        System.out.println("Player has: ");
        actionCards.forEach(card -> System.out.println(actionCards.indexOf(card) + 1 + ": " + card.getName()));
        var number = ZKlavesnice.readInt("Choose your action: ");
        if (number > 3 || number < 1) {
            activateActionCard(board);
        }
        actionCards.get(number-1).action(this, board);
    }


    private List<Duck> createDucks() {
        var ducks = new ArrayList<Duck>();
        for (int i = 0; i < 5; i++) {
            ducks.add(new Duck("Duck of player " + getName()));
        }
        return ducks;
    }

    public List<ActionCard> getActionCards() {
        return actionCards;
    }

    public void setActionCards(List<ActionCard> actionCards) {
        this.actionCards = actionCards;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Duck> getDuckList() {
        return duckList;
    }

    public void setDuckList(List<Duck> duckList) {
        this.duckList = duckList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
