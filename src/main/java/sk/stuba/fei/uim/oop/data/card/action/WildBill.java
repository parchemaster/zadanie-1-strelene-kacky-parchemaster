package sk.stuba.fei.uim.oop.data.card.action;

import sk.stuba.fei.uim.oop.data.Player;
import sk.stuba.fei.uim.oop.duck_hunt.Board;

public class WildBill extends ActionCard{
    private final String name;

    public WildBill(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void action(Player player, Board board) {
        System.out.println("starts wildBill");
    }
}
