package ru.job4j.tracker.game.orcs;

import ru.job4j.tracker.game.Heroes;

/**
 * shaman
 */
public class Shaman implements Heroes {
    private final int damage = 10;
    private int health = 100;
    private boolean magic = false;

    public int getHealth() {
        return health;
    }

    public void setHealth(int damage) {
        this.health -= damage;
    }

    public boolean getMagic() {
        return this.magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    //снятие улучшения с противника для след. хода
    public int attack() {
        return this.damage;
    }
}
