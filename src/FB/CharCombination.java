package FB;
import java.util.*;
/**
 * Created by mingyama on 10/31/17.
 */
public class CharCombination {
    public List<String> charCombination(String s, Map<Character, List<Character>> dictionary) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, dictionary, res, new StringBuilder(s), 0);
        return res;
    }

    private void helper(String s, Map<Character, List<Character>> dictionary, List<String> res, StringBuilder sb, int start) {
        // base case
        if (start == s.length()) {
            res.add(sb.toString());
            return;
        }

//        if (!dictionary.containsKey(s.charAt(start))) {
//            return;
//        }
        char origin = s.charAt(start);
        List<Character> replacements = dictionary.get(origin);
        for (int i = 0; i < replacements.size(); i++) {
            sb.replace(start, start+1, replacements.get(i) +"");
            helper(s, dictionary, res, sb, start+1);
            sb.replace(start, start+1, origin+"");
        }
    }

    public static void main(String[] a) {
        Map<Character, List<Character>> dictionary = new HashMap<>();
        List<Character> As = new LinkedList<>();
        As.add('b');
        As.add('c');
        List<Character> Ds = new LinkedList<>();
        Ds.add('e');
        Ds.add('f');
        dictionary.put('a', As);
        dictionary.put('d', Ds);
        System.out.println(new CharCombination().charCombination("ad", dictionary));
    }
}
