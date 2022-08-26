package ru.job4j.tracker;

import java.util.List;

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
        List<Item> all = tracker.findAll();
        Item item = all.get(all.size() - 1);
        int size = item.getId() - all.size();
        for (int i = item.getId(); i >= size; i--) {
            tracker.delete(i);
        }
        return true;
    }
}
