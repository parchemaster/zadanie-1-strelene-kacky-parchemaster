package sk.stuba.fei.uim.oop.data.card;

public class Lake extends DuckDeck {
    private final String name;
    private boolean isGunpoint;

    public Lake(String name) {
        super(name);
        this.name = name;
    }

    public boolean isGunpoint() {
        return isGunpoint;
    }

    public void setGunpoint(boolean gunpoint) {
        isGunpoint = gunpoint;
    }
}
