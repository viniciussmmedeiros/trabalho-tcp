package enums;

public enum KeyLookup {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");

    KeyLookup(String convertedKey) {
        this.convertedKey = convertedKey;
    }

    private final String convertedKey;
}