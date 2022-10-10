package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("item1"));
        tracker.add(new Item("item2"));
        tracker.add(new Item("item3"));
        DeleteAction del = new DeleteAction(out);

        Input input1 = mock(Input.class);
        Input input2 = mock(Input.class);

        when(input1.askInt(any(String.class))).thenReturn(1);
        when(input2.askInt(any(String.class))).thenReturn(2);

        del.execute(input1, tracker);
        del.execute(input2, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln
                                        + "=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("item3"));
        assertThat(tracker.findAll().size(), is(1));
    }
}