package ru.netology;
import java.util.Comparator;

public class TicketTimeComparator implements Comparator <Ticket> {
    @Override
    public int compare(Ticket t2, Ticket t1) {
        if (t1.getTimeFrom() - t1.getTimeTo() < t2.getTimeFrom() - t2.getTimeTo()) {
            return -1;
        } else if (t1.getTimeFrom() - t1.getTimeTo() > t2.getTimeFrom() - t2.getTimeTo()) {
            return 1;
        } else {
            return 0;
        }
    }
}
