package utils;

public class ParamValidator {

    public final static boolean checkLincencePlate(String licencePlate) {
        boolean result = false;
        if (checkLength(licencePlate.length(), 7)) {
            String start = licencePlate.substring(0, 3);
            char middle = licencePlate.charAt(3);
            String end = licencePlate.substring(4);
            result = checkLicencePlateStart(start)
                    && checkLicencePlateMiddle(middle)
                    && checkLicensePlateEnd(end);
        }
        return result;
    }

    private static boolean checkLength(int unitToCheck, int target) {
        return unitToCheck == target;
    }

    private static boolean checkLicencePlateStart(String start) {
        return isLettersOnly(start) && isBetween(start.length(), 3, 3);
    }

    private static boolean checkLicencePlateMiddle(char middle) {
        return middle == '-';
    }

    private static boolean checkLicensePlateEnd(String end) {
        return isDigitsOnly(end) && isBetween(end.length(), 3, 3);
    }

    public final static boolean isBetween(int unitToCheck, int lower, int upper) {
        return unitToCheck >= lower && unitToCheck <= upper;
    }

    public final static boolean isLettersOnly(String str) {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }

    public final static boolean isDigitsOnly(String str) {
        return str.matches("[0-9]+");
    }
}
