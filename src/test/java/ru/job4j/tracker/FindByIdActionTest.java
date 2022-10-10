package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        FindByIdAction fbi = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        fbi.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + tracker.findById(1) + ln));
        assertThat(tracker.findAll().get(1).getName(), is("item2"));
        assertThat(tracker.findAll().size(), is(3));
    }
}