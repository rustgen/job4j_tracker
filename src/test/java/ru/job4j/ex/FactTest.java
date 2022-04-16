package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenNless0() {
        Fact.calc(-1);
    }

    @Test
    public void whenN2() {
        int rsl = Fact.calc(2);
        assertThat(rsl, is(0));
    }
}