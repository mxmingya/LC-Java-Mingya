package TiaoCao;

public class ReverseWordsInAStringIII557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse().toString());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
