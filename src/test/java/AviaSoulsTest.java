import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldSortByPrice() {
        AviaSouls souls = new AviaSouls();
        Ticket t1 = new Ticket("SVO", "HEL", 500, 10, 12);
        Ticket t2 = new Ticket("SVO", "HEL", 100, 11, 14);
        Ticket t3 = new Ticket("SVO", "HEL", 300, 12, 16);

        souls.add(t1);
        souls.add(t2);
        souls.add(t3);

        Ticket[] expected = {t2, t3, t1}; // 100, 300, 500
        Ticket[] actual = souls.search("SVO", "HEL");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTime() {
        AviaSouls souls = new AviaSouls();
        Ticket t1 = new Ticket("MSK", "SPB", 500, 10, 15); // 5ч
        Ticket t2 = new Ticket("MSK", "SPB", 100, 10, 12); // 2ч
        Ticket t3 = new Ticket("MSK", "SPB", 800, 10, 11); // 1ч

        souls.add(t1);
        souls.add(t2);
        souls.add(t3);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {t3, t2, t1}; // 1ч, 2ч, 5ч
        Ticket[] actual = souls.searchAndSortBy("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}