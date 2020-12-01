package ru.job4j.tracker.lambda.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list, int num) {
        Predicate<Attachment> predicate =  new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > num;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Predicate<Attachment> predicate =  new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains(name);
            }
        };
        return filter(list, predicate);
    }

}