package ru.job4j.tracker;

public class DeleteManyAction implements UserAction {
    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete 1 million Items ===");
        for (int i = 0; i < 1000000; i++) {
            tracker.delete(i);
        }
        return true;
    }
}
