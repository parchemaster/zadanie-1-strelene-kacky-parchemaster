package sk.stuba.fei.uim.oop.data;

import sk.stuba.fei.uim.oop.data.card.Duck;

import java.util.List;

public class Player {
    private String name;
    private List<Duck> duckList;
    private boolean isActive;

    public Player(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
