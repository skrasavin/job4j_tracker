package ru.job4j.tracker.game.orcs;

import ru.job4j.tracker.game.Heroes;

/**
 * goblin
 */
public class Goblin implements Heroes {
    private final int damage = 20;
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

    public int attack() {
        return this.damage;
    }
}


//атака дубиной (нанесение урона 20 HP)