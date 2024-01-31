import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("  hello world  "));
        System.out.println(new ReverseWords().reverseWordsDqueue("  hello  world  "));
    }

    public String reverseWords(String s) {

        String[] arr = s.trim().split("\\s+");

        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String reverseWordsDqueue(String s) {

        s = s.trim();

        Deque<String> d = new ArrayDeque<>();
        int left = 0;
        int right = s.length() -1;
        StringBuilder sb = new StringBuilder();
        while(left<=right) {
            if(s.charAt(left) == ' ' && sb.length() > 0) {
                d.offerFirst(sb.toString());
                sb.setLength(0);
            } else if(s.charAt(left) != ' '){
                sb.append(s.charAt(left));
            }
            left++;
        }
        if(sb.length()>0) {
            d.offerFirst(sb.toString());
        }

        return String.join(" ", d);
    }
}
