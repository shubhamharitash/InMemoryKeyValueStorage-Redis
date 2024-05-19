package service;

public class DataTypeChecker {

    public static boolean isDouble(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isBoolean(String str) {
        if (str == null) {
            return false;
        }
        return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str);
    }

    public static String determineType(String str) {
        if (isBoolean(str)) {
            return "Boolean";
        } else if (isInteger(str)) {
            return "Integer";
        } else if (isDouble(str)) {
            return "Double";
        } else {
            return "String";
        }
    }
}
