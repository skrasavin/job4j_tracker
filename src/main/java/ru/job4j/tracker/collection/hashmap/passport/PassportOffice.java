package ru.job4j.tracker.collection.hashmap.passport;

import java.util.HashMap;
import java.util.Map;

/**
 * PassportOffice
 */
public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }

        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}