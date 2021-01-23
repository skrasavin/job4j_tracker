package ru.job4j.tracker.game.elves;

import ru.job4j.tracker.game.Heroes;

//атаковать мечом (нанесение урона 15 HP)

/**
 * elvFighter
 */
public class ElvFighter implements Heroes {
    private int damage = 15;
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
        return damage;
    }

    public boolean isMagic() {
        return false;
    }
}
