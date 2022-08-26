package ru.job4j.tracker;

public class CreateManyAction implements UserAction {
    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create 100K new Items ===");
        for (int i = 1; i < 100000; i++) {
            tracker.add(new Item(String.format("new Item %s", i)));
        }
        return true;
    }
}
