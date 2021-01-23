package ru.job4j.tracker.game.elves;

import ru.job4j.tracker.game.Heroes;

import java.util.*;

//стрелять из лука (нанесение урона 7 HP)
//атаковать противника (нанесение урона 3 HP)

/**
 * ElvArcher
 */
public class ElvArcher implements Heroes {
    private int bow = 7;
    private int damage = 3;
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
        List l = new ArrayList(Arrays.asList(bow, damage));
        int value = new Random().nextInt(2);
        return (int) l.get(value);
    }
}
