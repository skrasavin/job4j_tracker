package ru.job4j.tracker.lambda.streamapi;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

/**
 * card
 */
public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

public static void main(String[] args) {
    Stream.of(Suit.values())
            .flatMap(value -> Stream.of(Value.values())
            .map(suit -> value + " " + suit))
            .forEach(System.out::println);
}
}