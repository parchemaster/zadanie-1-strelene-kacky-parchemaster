package sk.stuba.fei.uim.oop.data;

import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.DuckDeck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private final List<Duck> duckList = new ArrayList<>();
    private final List<ActionCard> actionCards;
    private boolean isActive;
    private ActionCard chosenCard;

    public Player(String name) {
        this.name = name;
        this.isActive = true;
        actionCards = new ArrayList<>();
    }

    // player gets action card
    public void dealActionCards(List<ActionCard> actionDeck) {
        getActionCards().add(actionDeck.get(0));
        actionDeck.remove(0);
    }

    // use action card
    public void activateActionCard(Board board) {
        System.out.println("Player " + getName() + " has : ");
        actionCards.forEach(card -> System.out.println(actionCards.indexOf(card) + 1 + ": " + card.getName()));
        if (!isExceptionShoot(board)) {
            var number = ZKlavesnice.readInt("Choose your action: ", 3);
//            if (number > 3 || number < 1) {
//                activateActionCard(board);
//                return;
//            }
            actionCards.get(number - 1).action(this, board);
            setChosenCard(getActionCards().get(number-1));
        }
    }

    // check for every shoot action card
    private boolean isExceptionShoot(Board board) {
        var isAimedException = false;
        if (getActionCards().get(0).getName().equals(getActionCards().get(1).getName())
                && getActionCards().get(0).getName().equals(getActionCards().get(2).getName())
                && getActionCards().get(0).getName().equals("Shoot")) {
            var isAnyAimed = false;
            for (var aimField : board.getAimField()) {
                if (aimField) {
                    isAnyAimed = true;
                    break;
                }
            }
            if (!isAnyAimed) {
                System.out.println("!!! You cant play any your shoot card, because there is no one aimed duck!!!");
                var changeCard = actionCards.get(0);
                var actionDeck = board.getActionDeck();
                actionDeck.add(actionDeck.size(), changeCard);
                getActionCards().remove(changeCard);
                dealActionCards(actionDeck);
                isAimedException = true;
            }
        }
        return isAimedException;
    }


    public List<ActionCard> getActionCards() {
        return actionCards;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActionCard getChosenCard() {
        return chosenCard;
    }

    public void setChosenCard(ActionCard chosenCard) {
        this.chosenCard = chosenCard;
    }
}
