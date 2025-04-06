package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Казань", "Москва",2500,10,12);
    Ticket ticket2 = new Ticket("Казань", "Москва",2300,11,12);

    Ticket ticket3 = new Ticket("Казань", "Самара",2300,11,12);

    Ticket ticket4 = new Ticket("Самара", "Москва",2300,11,12);

    Ticket ticket5 = new Ticket("Казань", "Москва",2100,21,24);

    @Test
    public void shouldCompareTo() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        Ticket[] actual = avia.search("Казань", "Москва");
        Ticket[] expected = {ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket5);
        Ticket[] actual = avia.search("Казань", "Москва");
        Ticket[] expected = {ticket5, ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortBy() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] actual = avia.searchAndSortBy("Казань", "Москва", timeComparator);
        Ticket[] expected = {ticket2, ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }
}
