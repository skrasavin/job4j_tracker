package ru.job4j.tracker;

/**
 * Input
 */
public interface Input {
    /**
     * askStr
     * @param question test
     * @return ask
     */
    String askStr(String question);

    /**
     * askInt
     * @param question test
     * @return count
     */
    int askInt(String question);
}