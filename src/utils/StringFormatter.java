package utils;

public class StringFormatter {

    public final static String firstCharUpperRestLower(String data) {
        String firstLetter = data.substring(0, 1).
                toUpperCase();
        String restLetters = data.substring(1).
                toLowerCase();
        return firstLetter + restLetters;
    }
}
