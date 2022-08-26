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
        out.println("=== Delete many Items (all) ===");
        for (int i = 2_999_999; i > 0; i--) {
            tracker.delete(i);
        }
        return true;
    }
}
