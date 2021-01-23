package ru.job4j.tracker.game.orcs;

import ru.job4j.tracker.game.Heroes;

/**
 * archer
 */
public class Archer implements Heroes {
    private final int bow = 3;
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
        return this.bow;
    }
}
//стрелять из лука (нанесение урона 3 HP)
//удар клинком (нанесение урона 2 HP)