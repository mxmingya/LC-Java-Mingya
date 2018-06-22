package FB;

/**
 * Created by mingyama on 11/1/17.
 */
public class RemoveInvalidParenthesisII {

    public String removeInvalid(String parenthesis) {
        if (parenthesis == null || parenthesis.length() == 0) return "";
        int left = 0;
        for (char c : parenthesis.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            }
        }
//        System.out.println(left);
        int index = 0;
        StringBuilder res = new StringBuilder(parenthesis);
        while (left > 0 && index < parenthesis.length()) {
            if (parenthesis.charAt(index) == '(') {
                res.deleteCharAt(index);
                left--;
            } else {
                index++;
            }
        }

        while (left < 0 && index < parenthesis.length()) {
            if (parenthesis.charAt(index) == ')') {
                res.deleteCharAt(index);
                left++;
            }
            else {
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] a) {
        System.out.println(new RemoveInvalidParenthesisII().removeInvalid("((())"));
        System.out.println(new RemoveInvalidParenthesisII().removeInvalid("((("));
        System.out.println(new RemoveInvalidParenthesisII().removeInvalid("((()"));
        System.out.println(new RemoveInvalidParenthesisII().removeInvalid("((()))))"));
    }
}
