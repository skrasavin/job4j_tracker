package ru.job4j.tracker.collection.hashmap.order;

import java.util.HashMap;
import java.util.List;

/**
 * OrderConvert
 */
public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}