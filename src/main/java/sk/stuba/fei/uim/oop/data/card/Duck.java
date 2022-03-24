package sk.stuba.fei.uim.oop.data.card;


public class Duck extends DuckDeck {
    private final String name;
    public Duck(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
