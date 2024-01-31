import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagram().groupAnagrams(arr));
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            for(char c : str.toCharArray()) {
                int ind = c - 'a';
                arr[ind] = arr[ind] + 1;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                if(arr[i] != 0) {
                    sb.append((char)(i + 97)).append("#").append(arr[i]);
                    arr[i] = 0;
                }
            }
            map.computeIfAbsent(sb.toString(), key -> new ArrayList<String>()).add(str);
        }

        return map.values().stream().toList();
    }
}
