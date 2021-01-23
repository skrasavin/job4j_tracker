package ru.job4j.tracker.game;

/**
 * Heroes
 */
public interface Heroes {
    int attack();

    int getHealth();

    void setHealth(int damage);

    boolean getMagic();

    void setMagic(boolean magic);
}
