//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Collections;   // <- plural
import java.util.Comparator;
public class Main {

    private static boolean isVowel(char c) {
        return "AEIOUYaeiouy".indexOf(c) >= 0; // Y treated as vowel
    }

    private static String compress(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isVowel(ch)) sb.append(ch);
        }
        return sb.toString();
    }

    public static boolean isMatch(String original, String compressed) {
        if (original.isEmpty() || compressed.isEmpty())
            return false;
        if (original.charAt(0) != compressed.charAt(0))
            return false;
        return compress(original).equals(compressed);
    }

    public static String findClosestMatch(String[] names, String compressed) {
        ArrayList<String> matches = new ArrayList<>();
        for (String name : names) {
            if (isMatch(name, compressed))
                matches.add(name);
        }
        if (matches.isEmpty())
            return "NO MATCH";

        Collections.sort(matches, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                char la = a.charAt(a.length() - 1);
                char lb = b.charAt(b.length() - 1);
                int byLastChar = Character.compare(la, lb);
                if (byLastChar != 0) return byLastChar;        // earlier last char wins
                int byLen = Integer.compare(a.length(), b.length());
                if (byLen != 0) return byLen;                   // then shorter wins
                return a.compareTo(b);                          // then lexicographic
            }
        });

        return matches.get(0);
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            String[] originalNames = {"Alice", "Alicia", "Alfred", "Albert"};
            String compressedName = "Alfrd";
            System.out.println(findClosestMatch(originalNames, compressedName));
            String[] names2 = {"Emma", "Emily", "Emanuel"};
            String compressed2 = "Eml";
            System.out.println(findClosestMatch(names2, compressed2));
            String[] names3 = {"Brian", "Brenda", "Brock"};
            String compressed3 = "Bz";
            System.out.println(findClosestMatch(names3, compressed3));

    }
}