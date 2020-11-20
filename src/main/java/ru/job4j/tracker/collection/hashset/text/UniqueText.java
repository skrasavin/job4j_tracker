package ru.job4j.tracker.collection.hashset.text;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        Collections.addAll(check, origin);
        for (String tex : text) {
            rsl = check.contains(tex);
            if (!rsl) {
                break;
            }
        }

        return rsl;
    }
}