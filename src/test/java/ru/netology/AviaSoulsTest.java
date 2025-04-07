package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Казань", "Москва", 2500, 10, 12);
    Ticket ticket2 = new Ticket("Казань", "Москва", 2300, 11, 12);

    Ticket ticket3 = new Ticket("Казань", "Самара", 2300, 11, 12);

    Ticket ticket4 = new Ticket("Самара", "Москва", 2300, 11, 12);

    Ticket ticket5 = new Ticket("Казань", "Москва", 2100, 21, 24);

    AviaSouls avia = new AviaSouls();

    @Test
    public void shouldCompareTo() {
        AviaSouls avia1 = new AviaSouls();
        avia1.add(ticket1);
        avia1.add(ticket2);
        Ticket[] actual = avia1.search("Казань", "Москва");
        Ticket[] expected = {ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @BeforeEach
    public void init() {
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
    }

    @Test
    public void shouldSearch() {
        Ticket[] actual = avia.search("Казань", "Москва");
        Ticket[] expected = {ticket5, ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoSearch() {
        Ticket[] actual = avia.search("Казань", "Пенза");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneSearch() {
        Ticket[] actual = avia.search("Казань", "Самара");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortBy() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] actual = avia.searchAndSortBy("Казань", "Москва", timeComparator);
        Ticket[] expected = {ticket2, ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoSearchAndSortBy() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] actual = avia.searchAndSortBy("Казань", "Пенза", timeComparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneSearchAndSortBy() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] actual = avia.searchAndSortBy("Казань", "Самара", timeComparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
}
