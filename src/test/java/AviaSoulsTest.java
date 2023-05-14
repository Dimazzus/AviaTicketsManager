package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void testSortTickets() {


        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected ={ticket1, ticket2, ticket6, ticket8,ticket5};
        Ticket[] actual = manager.search("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortByOneTicket() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected ={ticket4};
        Ticket[] actual = manager.search("MSK", "PSK");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortNoTickets() {


        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 18);
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("MSK","NY");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortTicketsWithComparator() {


        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 16);//3
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 17);//1
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);//2
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 13);//4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected ={ticket5, ticket1, ticket6, ticket2,ticket8};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortOneTicketWithComparator() {


        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 16);//3
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 17);//1
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);//2
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 13);//4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected ={ticket7};
        Ticket[] actual = manager.search("MSK", "HK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortNoTicketsWithComparator() {


        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 5_000, 12, 14);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 5_000, 13, 16);//3
        Ticket ticket3 = new Ticket("MSK", "UFA", 7_000, 12, 15);
        Ticket ticket4 = new Ticket("MSK", "PSK", 18_000, 14, 22);
        Ticket ticket5 = new Ticket("MSK", "SPB", 8_000, 16, 17);//1
        Ticket ticket6 = new Ticket("MSK", "SPB", 6_000, 10, 12);//2
        Ticket ticket7 = new Ticket("MSK", "HK", 38_000, 11, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 7_000, 9, 13);//4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected ={};
        Ticket[] actual = manager.search("MSK", "VVO", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}
