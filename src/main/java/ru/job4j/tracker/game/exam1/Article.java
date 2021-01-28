package ru.job4j.tracker.game.exam1;

import java.util.Arrays;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String originResult = origin.replaceAll("[-+.^:,!;]","");
        var originText = new HashSet<>(Arrays.asList(originResult.split(" ")));

        String lineResult = line.replaceAll("[-+.^:,!;]","");
        var lineText = new HashSet<>(Arrays.asList(lineResult.split(" ")));

        for(var str : lineText) {
            if (!originText.contains(str)) {
                return false;
            }
        }

        return true;
    }
}

