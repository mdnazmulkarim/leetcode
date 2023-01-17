import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
      List<String> list = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while(!queue.isEmpty()) {
            String str = queue.remove();
            int l = countChar(str, '(', n);
            int r = countChar(str, ')', n);

            if(l == n && r == n) {
                list.add(str);
            } else {
                List<String> nextMove = getNextValid(n-l,n-r);
                nextMove.forEach(item -> {
                    queue.add(str+item);
                });
            }
        }

      return list;
    }

    private List<String> getNextValid(int left, int right) {
        Item item = new Item(left, right);

        return item.generateNextValid();
    }

    private int countChar(String str, char c, int max) {
        int count = 0;
      for(int i=0; i< str.length(); i++) {
          if (str.charAt(i) == c) {
              count++;
          }
      }
      return count;
    }

    class Item {
        int countLeft;
        int countRight;

        Item (int l, int r) {
            this.countLeft = l;
            this.countRight = r;
        }

        public List<String> generateNextValid() {
            List<String> list = new ArrayList<>();

            if(countLeft != 0 && countLeft == countRight) {
                list.add("(");
            } else if(countRight > countLeft && countLeft > 0 && countRight > 0) {
                list.add("(");
                list.add(")");
            } else if(countLeft < 1 && countRight > 0) {
                list.add(")");
            }
            return list;
        }

    }
}
