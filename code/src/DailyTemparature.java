import java.util.Arrays;
import java.util.Stack;

public class DailyTemparature {
    public static void main(String[] args) {

        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new DailyTemparature().dailyTemperatures(arr)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int[] result = new int[temperatures.length];

        for(int i=1; i< temperatures.length; i++)  {

            if(temperatures[i]<= temperatures[stack.peek()]) {
                stack.push( i);
            } else {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return result;
    }
}
