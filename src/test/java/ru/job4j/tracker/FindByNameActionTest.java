package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        String name = tracker.findById(2).getName();
        FindByNameAction fbn = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        fbn.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + tracker.findById(2) + ln));
        assertThat(tracker.findById(2).getName(), is("item2"));
        assertThat(tracker.findAll().get(1).getName(), is("item2"));
    }
}