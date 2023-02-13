
//https://programming.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        //System.out.println(new LongestSubStringWithoutRepeatingCharacter().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubStringWithoutRepeatingCharacter().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int i = 0;
        int max =0;

        while (i < s.length()) {
            int j=i;
            int k=0;
            boolean repeated = false;
            while(j< s.length() && !repeated) {
                if(!set.contains(s.charAt(j))) {
                    k++;
                    set.add(s.charAt(j));
                } else {
                    repeated = true;
                    if (k > max) {
                        max = k;
                    }
                    k=0;
                }
                j++;
            }
            if(j>=s.length()) {
                if (k > max) {
                    max = k;
                }

            }
            set.clear();;
            i++;
        }

        return max;
    }

}
