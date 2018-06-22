package String;

public class StringCompression {
    public int compress(char[] chars) {
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            int cur = i;
            while (cur < chars.length && chars[cur] == chars[i]) {
                cur++;
            }
            chars[pre++] = chars[i];
            if (cur - i > 1) {
                for (char c : Integer.toString(cur-i).toCharArray()) {
                    chars[pre++] = c;
                }
            }
            i = cur-1;
            // pre == 2, i = 2,
            // cur = 5,
        }
        return pre;
    }
}
