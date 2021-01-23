package ru.job4j.tracker.game.elves;

import ru.job4j.tracker.game.Heroes;

//наложение улучшения на персонажа своего отряда
//нанесение урона персонажу противника магией на 10 HP

/**
 * elvwizard
 */
public class ElvWizard implements Heroes {
    private int damage = 10;
    private int health = 100;
    private boolean magic = true;

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
}
