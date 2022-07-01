package ls.comm.util;

/**
 * @author dlins
 */
public class Strings {

    public static boolean isEmpty(String str) {
        return Objects.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return Objects.isNotEmpty(str);
    }

    public static boolean isBlank(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }
}
