package OA;

public class ShutterflyOA {
    static String uncompress(String src) {
        if(src == null || src.length() <= 1){
            return src;        }
            char[] array = src.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            if(Character.isDigit(array[i])) {
                long count = 0;
                while(Character.isDigit(array[i])) {
                    count = count * 10 + (int)(array[i] - '0');
                    i++;
                }
                char ch = array[i];
                while(count > 0) {
                    result.append(ch);
                    count--;
                }
            }
            else if(Character.isLetter(array[i])){
                result.append(array[i]);
            }        }
            return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(uncompress("1a"));
    }
}
