package ru.job4j.tracker.game.exam1;

import java.util.HashMap;

public class FreezeStr {

    public static HashMap<Character, Integer> inMap2(String text) {
        var letters = new HashMap<Character, Integer>();
        for (var a = 0; a < text.length(); a++) {
            int count = 0;

            for (var x = 0; x < text.length(); x++) {
                if (text.charAt(a) == text.charAt(x)) {
                    count++;
                }
            }

            letters.put(text.charAt(a), count);
        }

        return letters;
    }

    public static boolean eq(String left, String right) {
        var leftText = FreezeStr.inMap2(left);

        for (var a = 0; a < right.length()-1; a++) {
            if (!leftText.containsKey(right.charAt(a))) {
                return false;
            }else if (leftText.containsKey(right.charAt(a)) &&
                      leftText.get(right.charAt(a)) > 1) {
                leftText.replace(right.charAt(a), leftText.get(right.charAt(a)) - 1);
            }else if(leftText.containsKey(right.charAt(a)) &&
                    leftText.get(right.charAt(a)) == 1) {
                leftText.remove(right.charAt(a));
            }
        }

        return true;
    }
}