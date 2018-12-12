package ua.edu.ukma.ykrukovska.unit14.utils;

public class StringUtils {
    public static String replaceSubstring(String originalStr, String editedStr, String changeStr) {
        int pos = positionOfSubstring(originalStr, editedStr);
        if (pos < 0) {
            return originalStr;
        }
        String result = "";
        for (int i = 0; i < pos; i++) {
            result += originalStr.charAt(i);
        }
        result += changeStr;
        for (int i = pos + editedStr.length(); i < originalStr.length(); i++) {
            result += originalStr.charAt(i);
        }
        return result;
    }

    private static int positionOfSubstring(String originalStr, String editedStr) {

        if (!isParamsValid(originalStr, editedStr)) {
            return -1;
        }


        for (int i = 0; i <= originalStr.length() - editedStr.length(); i++) {
            boolean hasSubstring = true;
            for (int j = 0; j < editedStr.length(); j++) {
                if (originalStr.charAt(i + j) != editedStr.charAt(j)) {
                    hasSubstring = false;
                    break;
                }
            }
            if (hasSubstring)
                return i;
        }
        return -1;
    }

    private static boolean isParamsValid(String originalStr, String editedStr) {
        return !(originalStr == null || originalStr.length() == 0 ||
                editedStr == null || editedStr.length() == 0 ||
                editedStr.length() > originalStr.length());
    }

}
