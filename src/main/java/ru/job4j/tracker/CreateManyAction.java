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
        out.println("=== Create 1 million new Items ===");
        for (int i = 0; i < 1000000; i++) {
            tracker.add(new Item(input.askStr(String.format("new Item %s", i))));
        }
        return true;
    }
}
