package BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingyama on 9/21/17.
 */
public class LetterCombinationsOfPhoneNumbers {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', new LinkedList<Character>(){{
            add('a');
            add('b');
            add('c');}});
        map.put('3', new LinkedList<Character>(){{
            add('d');
            add('e');
            add('f');}});
        map.put('4', new LinkedList<Character>(){{
            add('g');
            add('h');
            add('i');}});
        map.put('5', new LinkedList<Character>(){{
            add('j');
            add('k');
            add('l');}});
        map.put('6', new LinkedList<Character>(){{
            add('m');
            add('n');
            add('o');}});
        map.put('7', new LinkedList<Character>(){{
            add('p');
            add('q');
            add('r');
        add('s');}});
        map.put('8', new LinkedList<Character>(){{
            add('t');
            add('u');
            add('v');}});
        map.put('9', new LinkedList<Character>(){{
            add('w');
            add('x');
            add('y');
        add('z');}});
        map.put('0', new LinkedList<Character>());
        map.put('1', new LinkedList<Character>());
        List<String> result = new LinkedList<>();
        Helper(digits, map, new StringBuilder(), result, 0);
        return result;
    }

    private void Helper(String digits, HashMap<Character, List<Character>> map, StringBuilder current, List<String> result, int start) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }

        List<Character> digit = map.get(digits.charAt(start));
        for (int i = 0; i < digit.size(); i++) {
            current.append(digit.get(i));
            Helper(digits, map, current, result, start + 1);
            current.deleteCharAt(current.length()-1);
        }
    }

    public List<String> letterCombinations_2(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null||digits.length() == 0) return res;
        String[] dictionary = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, res, new StringBuilder(), 0, dictionary);
        return res;
    }

    private void dfs(String digits, List<String> res, StringBuilder cur, int start, String[] dictionary) {
        if (digits.length() == cur.length()) {
            res.add(cur.toString());
            return;
        }
        int index = Integer.parseInt(digits.charAt(start) + "");
        String curDigits = dictionary[index];
//        System.out.println(curDigits);
        for (int i = 0; i < curDigits.length(); i++) {
            cur.append(curDigits.charAt(i));
            dfs(digits, res, cur, start+1, dictionary);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        for (String s : new LetterCombinationsOfPhoneNumbers().letterCombinations("234")) System.out.printf("%s ", s);
        System.out.println("");
        for (String s : new LetterCombinationsOfPhoneNumbers().letterCombinations_2("234")) System.out.printf("%s ", s);
    }
}
