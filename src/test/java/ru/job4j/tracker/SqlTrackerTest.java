package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveTwoItemsWithSameNameAndFindByGeneratedNameThenMustBeTwoItemsWithSameName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item1"));
        Item item4 = tracker.add(new Item("item4"));
        String name = item1.getName();
        List<Item> items = tracker.findByName(name);
        assertThat(items.size(), is(2));
    }

    @Test
    public void whenSaveFourItemsAndFindAllItemsShouldShowAllAddedItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Item item4 = tracker.add(new Item("item4"));
        assertThat(tracker.findAll(), is(List.of(item1, item2, item3, item4)));
    }

    @Test
    public void whenSaveFourItemsAndDeleteItemsShouldShowAllLeftItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Item item4 = tracker.add(new Item("item4"));
        int id1 = item1.getId();
        int id2 = item2.getId();
        tracker.delete(id2);
        assertThat(tracker.findById(id1), is(item1));
        assertThat(tracker.findAll(), is(List.of(item1, item3, item4)));
    }

    @Test
    public void whenSaveFourItemsAndReplaceItemsShouldShowAllItemsWithChanges() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item5 = new Item("item5");
        int id = item1.getId();
        assertThat(tracker.replace(id, item5), is(true));
    }
}