package ru.job4j.tracker.lambda.lambda;

import java.util.Comparator;

/**
 * Attachment
 */
public class Attachment {
    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

    public static void main(String[] args) {
        Comparator<Attachment> comparator = Comparator.comparingInt(Attachment::getSize);

        Comparator<Attachment> comparatorAtt = Comparator.comparing(Attachment::getName);

        Comparator<String> cmpText = Comparator.naturalOrder();

        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();

        Comparator<String> compar = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return right.length() - left.length();
        };
    }
}