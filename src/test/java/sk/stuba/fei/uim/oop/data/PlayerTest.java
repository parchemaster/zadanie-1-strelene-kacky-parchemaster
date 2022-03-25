package sk.stuba.fei.uim.oop.data;

import org.junit.Test;
import sk.stuba.fei.uim.oop.data.card.Duck;
import sk.stuba.fei.uim.oop.data.card.action.ActionCard;
import sk.stuba.fei.uim.oop.data.card.action.Shoot;
import sk.stuba.fei.uim.oop.duck_hunt.Board;
import sk.stuba.fei.uim.oop.duck_hunt.DuckHunt;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTest {

    private String name;
    private List<Duck> duckList = new ArrayList<>() {};
    private List<ActionCard> actionCards;
    private boolean isActive;


    DuckHunt duckHunt = new DuckHunt();
    Board board = new Board(duckHunt.getActionDeck(), duckHunt.getDuckDeck(), duckHunt.getPlayers());


    public void createProperties() {
        setName("Test player");
        setActionCards(new ArrayList<ActionCard>(
                Arrays.asList(new Shoot("Shoot"), new Shoot("Shoot"),
                        new Shoot("Shoot"))
        ));
    }

//    @Test
//    public void activateActionCard() {
//        createProperties();
//
//
//        System.out.println("Player " + getName() + " has : ");
//        actionCards.forEach(card -> System.out.println(actionCards.indexOf(card) + 1 + ": " + card.getName()));
//        if (isExceptionShoot()) {
//            var number = ZKlavesnice.readInt("Choose your action: ");
//            if (number > 3 || number < 1) {
//                activateActionCard();
//            }
////            actionCards.get(number - 1).action(this, board);
////            actionCards.remove(number - 1);
////            dealActionCards(board.getActionDeck());
//        }
//    }

    @Test
    public void isExceptionShoot() {
        createProperties();
        board.getAimField().set(1, true);
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
                var number = 3;
                var changeCard = actionCards.get(number - 1);
                var actionDeck = board.getActionDeck();
                actionDeck.add(actionDeck.size(), changeCard);
                getActionCards().remove(changeCard);
//                dealActionCards(actionDeck);
                isAimedException = true;
                getActionCards().add(actionDeck.get(0));
//            actionDeck.remove(0);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ActionCard> getActionCards() {
        return actionCards;
    }

    public void setActionCards(List<ActionCard> actionCards) {
        this.actionCards = actionCards;
    }

}