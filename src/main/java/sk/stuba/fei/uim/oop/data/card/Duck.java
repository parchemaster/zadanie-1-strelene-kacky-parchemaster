package sk.stuba.fei.uim.oop.data.card;


public class Duck extends DuckDeck {
    private final String name;
    private boolean isGunpoint;
    public Duck(String name) {
        super(name);
        this.name = name;
        this.isGunpoint = false;
    }

    @Override
    public String getName() {
        return name + (getIsGunpoint() ? " is aimed" : " isn't aimed");
    }

    public boolean getIsGunpoint() {
        return isGunpoint;
    }

    public void setGunpoint(boolean gunpoint) {
        isGunpoint = gunpoint;
    }

}
