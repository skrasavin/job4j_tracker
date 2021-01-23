package ru.job4j.tracker.game;
import com.sun.source.tree.LiteralTree;
import ru.job4j.tracker.game.elves.*;
import ru.job4j.tracker.game.orcs.*;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Battle
 */
public class Battle {

    private List<Heroes> elves = new ArrayList<>(Arrays.asList(
            new ElvArcher(), new ElvArcher(), new ElvArcher(),
            new ElvFighter(), new ElvFighter(),
            new ElvWizard()));
    private List<Heroes> orcs = new ArrayList<>(Arrays.asList(
            new Archer(), new Archer(), new Archer(),
            new Goblin(), new Goblin(),
            new Shaman()));
//    List<Heroes> peoples = new ArrayList<Heroes>(Arrays.asList(
//                  new ElvArcher(), new ElvFighter(), new ElvWizard()));
//    List<Heroes> undead = new ArrayList<Heroes>(Arrays.asList(
//                  new ElvArcher(), new ElvFighter(), new ElvWizard()));


    FileWriter writer = new FileWriter("/home/serg/Загрузки/notes3.txt");

    private int round = 1;

    public Battle() throws IOException {
    }

    public Heroes makeChoise(List heroes) {
        return (Heroes) heroes.get(new Random().nextInt(heroes.size()));
    }

    public void removeFromList(Heroes heroy) {
        if (this.elves.contains(heroy)) {
            this.elves.remove(heroy);
            System.out.println("remove elvs");
        }
        if (this.orcs.contains(heroy)) {
            this.orcs.remove(heroy);
            System.out.println("remove orcs");
        }
        System.out.println("hello");
    }

    public void magic(Heroes heroy) {
        int roulette = new Random().nextInt(elves.size() - 1);
        if (this.elves.contains(heroy)) {
            this.elves.get(roulette).setMagic(true);
            System.out.println("Магию получил " + this.elves.get(roulette).getClass().getSimpleName());
        } else {
            this.orcs.get(roulette).setMagic(true);
            System.out.println("Магию получил " + this.orcs.get(roulette).getClass().getSimpleName());
        }
    }

    public Heroes makeBattle(Heroes heroy, Heroes secondHeroy) {
        String simpleClassName = heroy.getClass().getSimpleName();
        String simpleSecondHeroyName = secondHeroy.getClass().getSimpleName();
        System.out.println(simpleClassName  + "(" + heroy.getHealth() + " HP)"
                + " | Attack (" + heroy.attack() + ") -> "
                + simpleSecondHeroyName + "(" + secondHeroy.getHealth() + " HP)");
        if (simpleClassName.contains("Wizard") || simpleClassName.contains("Shaman")) {
            this.magic(heroy);
            secondHeroy.setHealth(heroy.attack());
        } else if (heroy.getMagic() && !simpleClassName.contains("Wizard")) {
            secondHeroy.setHealth(heroy.attack() * 2);
            System.out.println(heroy + "атакует с усилением - " + heroy.attack());
            heroy.setMagic(false);
        } else {
            secondHeroy.setHealth(heroy.attack());
        }
        if (secondHeroy.getHealth() <= 0) {
            return secondHeroy;
        }
        System.out.println(simpleClassName  + "(" + heroy.getHealth() + " HP)"
                + " | Attack (" + heroy.attack() + ") -> "
                + simpleSecondHeroyName + "(" + secondHeroy.getHealth() + " HP)");
        System.out.println("Эльфы - " + this.elves.size() + " Орки - " + this.orcs.size()  + '\n');
        return secondHeroy;

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Battle battle = new Battle();
        Heroes elv = battle.elves.get(new Random().nextInt(battle.elves.size()));
        Heroes orc = battle.orcs.get(new Random().nextInt(battle.orcs.size()));
        while (battle.elves.size() != 0 || battle.orcs.size() != 0) {
            Heroes rsl;
            elv = battle.makeChoise(battle.elves);
            orc = battle.makeChoise(battle.orcs);
            System.out.println("Round " + battle.round++ + " ");
            battle.writer.write(battle.round);
            Thread.sleep(100);
            if (battle.round % 2 != 1) {
                System.out.println("Атакуют Эльфы");
                battle.writer.write("Атакуют Эльфы");
                rsl = new Battle().makeBattle(elv, orc);
                if (rsl.getHealth() <= 0) {
                    battle.removeFromList(rsl);
                }
            } else {
                System.out.println("Атакуют Орки");
                battle.writer.write("Атакуют Орки");
                rsl = new Battle().makeBattle(orc, elv);
                if (rsl.getHealth() <= 0) {
                    battle.removeFromList(rsl);
                }
            }
        }
        battle.writer.close();
    }
}