package com.company.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {

    private static Map<String, Ticket> map = new ConcurrentHashMap<>();

    public static Ticket getTicket(String movieName) {
        if (map.containsKey(movieName)) {
            return map.get(movieName);
        } else {
            Ticket ticket = new MovieTicket(movieName);
            map.put(movieName, ticket);
            return ticket;
        }
    }

}
