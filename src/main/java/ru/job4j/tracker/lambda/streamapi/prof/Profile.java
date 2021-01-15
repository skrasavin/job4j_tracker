package ru.job4j.tracker.lambda.streamapi.prof;

/**
 * profile
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

