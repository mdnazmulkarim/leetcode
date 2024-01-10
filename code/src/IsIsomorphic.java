import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        //System.out.println(new IsIsomorphic().isIsomorphic("aba", "cdc"));
        //System.out.println(new IsIsomorphic().isIsomorphic("foo", "bar"));
        System.out.println(new IsIsomorphic().isIsomorphic("badc", "baba"));
        //System.out.println(new IsIsomorphic().isIsomorphic("paper", "title"));
              //p : t
              //a : i
              //e : l
              //r: e



        //badc : baba
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
