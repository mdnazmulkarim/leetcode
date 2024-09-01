import java.util.Stack;

public class RemovingStartFromAString {
    public static void main(String[] args) {

        System.out.println(new RemovingStartFromAString().removeStars("erase*****"));
    }

    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(c -> sb.append(c));
        return sb.toString();
    }
}
