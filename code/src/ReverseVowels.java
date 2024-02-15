import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        //String str = "hello";
        //String str = "leetcode";
        String str = "a.b,.";
        System.out.println(new ReverseVowels().reverseVowels(str));
    }

    public String reverseVowels(String s) {

        Set<Character> set = new HashSet<>((Arrays.asList('a', 'e','i','o','u',
                'A','E','I','O','U')));
        char[] charArr = s.toCharArray();
        int l=0;
        int r = s.length()-1;
        while (l<r) {
            while(!set.contains(s.charAt(l)) && l<r) {
                l++;
            }
            while(!set.contains(s.charAt(r)) && l<r) {
                r--;
            }
            if(l<=r) {
                charArr[l] = s.charAt(r);
                charArr[r] = s.charAt(l);
                l++;
                r--;
            }
        }
        return String.valueOf(charArr);
    }
}
