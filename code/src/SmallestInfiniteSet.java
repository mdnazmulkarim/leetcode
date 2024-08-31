import java.util.*;

public class SmallestInfiniteSet {

   // ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
   // [[],  [2],  [], [], [], [1],  [], [], []]
    //[null, null, 1, 2,  3,  null, 1,   4,  5 ]
    public static void main(String[] args) {
        SmallestInfiniteSet sInSet = new SmallestInfiniteSet();
        sInSet.print();
        sInSet.addBack(2);
        sInSet.print();

    }

    PriorityQueue<Integer> queue;
    Set<Integer> set;
    int currentNumber;

    void print() {
        System.out.println("set:"+Arrays.toString(set.toArray()));
        System.out.println("queue:"+Arrays.toString(queue.toArray()));
        System.out.println("current num:" + currentNumber);
    }
    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        set = new HashSet<>();
        currentNumber = 1;
    }

    public int popSmallest() {
        System.out.println("pop smallest:");
        if(!queue.isEmpty() && queue.peek() < currentNumber) {
            return queue.poll();
        } else {
            return currentNumber++;
        }
    }

    public void addBack(int num) {
        System.out.println("Add back: "+num);
        if(currentNumber<=num || queue.contains(num)) {
        } else {
            queue.add(num);
        }
    }
}
