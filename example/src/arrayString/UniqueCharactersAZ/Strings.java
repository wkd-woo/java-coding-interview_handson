package arrayString.UniqueCharactersAZ;

import java.util.HashMap;
import java.util.Map;

public class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void main(String[] args) {
        String text1 = "afghnqrsuz";
        String text2 = "abcdefhzqoc";
        String text3 = "abcdefhzqow";

        boolean resultText1 = Strings.isUniqueAZ(text1);
        boolean resultText2 = Strings.isUniqueAZ(text2);
        boolean resultText3 = Strings.isUniqueAZ(text3);

        System.out.println("Text1 has unique characters? " + resultText1);
        System.out.println("Text2 has unique characters? " + resultText2);
        System.out.println("Text3 has unique characters? " + resultText3);
    }

    public static boolean isUniqueAZ(String str) {
        if (str == null || str.isBlank()) {
            return false;
        }

        Map<Character, Integer> db = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (db.containsKey(str.charAt(i))) {
                return false;
            }
            db.put(str.charAt(i), 1);
        }

        return true;
    }

}
