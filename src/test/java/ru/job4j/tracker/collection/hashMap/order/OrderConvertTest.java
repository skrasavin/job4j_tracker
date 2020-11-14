package ru.job4j.tracker.collection.hashMap.order;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe1", "Dresses"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe1"), is(new Order("3sfe1", "Dresses")));
    }
}