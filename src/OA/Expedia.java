package OA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mingyama on 9/24/17.
 */
public class Expedia {
    private String[] sortString(String[] names) {
//        ArraysStackQueue.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                String[] temp = s1.split(" ");
//                String s11 = temp[0];
//                String s12 = temp[1];
//                temp = s2.split(" ");
//                String s21 = temp[0];
//                String s22 = temp[1];
//                if (!s11.equals(s21)) {
//                    return s1.compareToIgnoreCase(s21);
//                } else {
//                    return compareRomanNumeral(s12, s22);
//                }
//            }
//        });
        if (names == null || names.length == 0) return new String[0];
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I',1);
        romanToInt.put('X',10);
        romanToInt.put('C',100);
        romanToInt.put('M',1000);
        romanToInt.put('V',5);
        romanToInt.put('L',50);
        romanToInt.put('D',500);
        String[] strs = names.clone();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] temp = s1.split(" ");
                String s11 = temp[0]; // first half of name
                String s12 = temp[1]; // second half of name
                temp = s2.split(" ");
                String s21 = temp[0];
                String s22 = temp[1];
                if (s11.equals(s21)) {
                    // if the first half equals, compare the second half part of name
                    // translate roman numerals to integer and then compare
                    int val1 = 0;
                    int val2 = 0;
                    //for (int i = 0; i < s12.length()-1 && i < s22.length()-1; i++) {
                    //  int current = romanToInt.get(s12.charAt(i));
                    // int current2 = romanToInt.get(s22.charAt(i));
                    //if (romanToInt.get(s12.charAt(i+1)) > current) {
                    //   val1 -= current;
                    //} else {
                    //   val1 += current;
                    //}
                    //if (romanToInt.get(s22.charAt(i+1)) > current2) {
                    //    val2 -= current2;
                    //} else {
                    //   val2 =+ current2;
                    //}
                    //}
                    //val1 += romanToInt.get(s12.charAt(s12.length()-1));
                    //val2 += romanToInt.get(s22.charAt(s22.length()-1));
                    //return val1 < val2 ? -1 : 1;
                    int sum=0;
                    int sum2 = 0;
                    if(s22.indexOf("IV")!=-1){sum-=2;}
                    if(s22.indexOf("IX")!=-1){sum-=2;}
                    if(s22.indexOf("XL")!=-1){sum-=20;}
                    if(s22.indexOf("XC")!=-1){sum-=20;}
                    if(s22.indexOf("CD")!=-1){sum-=200;}
                    if(s22.indexOf("CM")!=-1){sum-=200;}

                    char c[]=s22.toCharArray();
                    int count=0;

                    for(;count<=s22.length()-1;count++){
                        if(c[count]=='M') sum+=1000;
                        if(c[count]=='D') sum+=500;
                        if(c[count]=='C') sum+=100;
                        if(c[count]=='L') sum+=50;
                        if(c[count]=='X') sum+=10;
                        if(c[count]=='V') sum+=5;
                        if(c[count]=='I') sum+=1;

                    }
                    if(s22.indexOf("IV")!=-1){sum2-=2;}
                    if(s22.indexOf("IX")!=-1){sum2-=2;}
                    if(s22.indexOf("XL")!=-1){sum2-=20;}
                    if(s22.indexOf("XC")!=-1){sum2-=20;}
                    if(s22.indexOf("CD")!=-1){sum2-=200;}
                    if(s22.indexOf("CM")!=-1){sum2-=200;}

                    char c2[]=s22.toCharArray();
                    int count2=0;

                    for(;count2<=s22.length()-1;count2++){
                        if(c2[count2]=='M') sum2+=1000;
                        if(c2[count2]=='D') sum2+=500;
                        if(c2[count2]=='C') sum2+=100;
                        if(c2[count2]=='L') sum2+=50;
                        if(c2[count2]=='X') sum2+=10;
                        if(c2[count2]=='V') sum2+=5;
                        if(c2[count2]=='I') sum2+=1;

                    }

                    return sum - sum2;

                }
                // if the first half is different
                else {
                    return s1.compareToIgnoreCase(s2);
                }
            }
        });
        return strs;
    }

    private int compareRomanNumeral(String s1, String s2) {
        Map<Character, Integer> romanToInt = new HashMap<>();
        romanToInt.put('I',1);
        romanToInt.put('X',10);
        romanToInt.put('C',100);
        romanToInt.put('M',1000);
        romanToInt.put('V',5);
        romanToInt.put('L',50);
        romanToInt.put('D',500);
        int val1 = 0;
        int val2 = 0;
        for(int i = 0; i < s1.length()-1 && i < s2.length()-1; i++) {
            int current = romanToInt.get(s1.charAt(i));
            int current2 = romanToInt.get(s2.charAt(i));
            if (romanToInt.get(s1.charAt(i+1)) > current) {
                val1 -= current;
            } else {
                val1 += current;
            }
            if (romanToInt.get(s2.charAt(i+1)) > current2) {
                val2 -= current2;
            } else {
                val2 =+ current2;
            }
        }
        // add last digit
        val1 += romanToInt.get(s1.charAt(s1.length()-1));
        val2 += romanToInt.get(s2.charAt(s2.length()-1));
        return val1 < val2 ? 1 : -1;
    }

    public static void main(String[] args) {
        String s1= "PILLIPS V";
        String s2 = "PILLIPS II";
        String[] s = {"Louis IX", "Louis VIII"};
        new Expedia().sortString(s);
        for (String str : s) {
            System.out.printf("%s ", str);
        }
//        System.out.println(new OA.Expedia().SherlockAndTheBeast(new int[] {1,3,5,11}));
    }
}
