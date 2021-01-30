package ru.job4j.tracker.game.exam1;

import java.util.HashMap;

public class FreezeStr {

    public static HashMap<Integer, Character> inMap(String text) {
        var words = new HashMap<Integer, Character>();

        for (var a = 0; a < text.length(); a++) {
            words.put(a, text.charAt(a));
        }

        return words;
    }

    public static boolean eq(String left, String right) {
        HashMap<Integer, Character> leftText = FreezeStr.inMap(left);
        HashMap<Integer, Character> rightText = FreezeStr.inMap(right);
        for (var a = 0; a < rightText.size() - 1; a++) {
            if (!leftText.containsValue(rightText.get(a))) {
                return false;
            }
            leftText.remove(a);
        }
        return true;
    }
}