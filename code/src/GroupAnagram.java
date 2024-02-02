import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagram().groupAnagrams(arr));
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        Map<String, List<Anagram>> map = new HashMap<>();

        for(String str : strs) {
            for(char c : str.toCharArray()) {
                int ind = c - 'a';
                arr[ind] = arr[ind] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(arr[i] != 0) {
                    sb.append((char)(i + 97)).append("#").append(arr[i]);
                    arr[i] = 0;
                }
            }
            map.computeIfAbsent(sb.toString(), key -> new ArrayList<>()).add(new Anagram(str));
        }

        for(List<Anagram> list : map.values()) {
            Collections.sort(list);
        }

        List<List<String>> newList = new ArrayList<>();
        for(List<Anagram> list : map.values()) {
            newList.add(list.stream().map(item -> item.str).collect(Collectors.toList()));
        }

        return newList;
    }

    static class Anagram implements Comparable<Anagram>{

        public Anagram(String str) {
            this.str = str;
            calculate();
        }
        int val;
        String str;

        void calculate() {
            int multiplier = 1;
            for(int  i= str.length(); i > 0; i--) {
                val = val + (str.charAt(i -1) - 'a') * multiplier;
                multiplier *= 10;
            }
        }

        @Override
        public int compareTo(Anagram o) {
            return Integer.compare(this.val, o.val);
        }
    }
}
