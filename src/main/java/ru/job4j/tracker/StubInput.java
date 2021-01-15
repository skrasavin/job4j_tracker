package ru.job4j.tracker;

/**
 * StubInput
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    /**
     * stubInput
     * @param answers test
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}