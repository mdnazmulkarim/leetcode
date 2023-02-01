import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(new CourseSchedule().canFinish(5, arr));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int[] arr : prerequisites) {
            if(map.containsKey(arr[0])) {
                map.get(arr[0]).add(arr[1]);
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(arr[1]);
                map.put(arr[0], hashSet);
            }
        }

        for(int[] arr : prerequisites) {
            Set<Integer> callerSet = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(arr[0]);
            while(!queue.isEmpty() && !callerSet.contains(queue.peek())) {
                int nextCaller = queue.poll();
                callerSet.add(nextCaller);
                if(map.containsKey(queue.peek())) {
                    queue.addAll(map.get(nextCaller));
                } else {
                    set.addAll(callerSet);
                }
            }
            if(set.size()>=numCourses) {
                return true;
            }
        }
        if(set.size()>=numCourses) {
            return true;
        }

        return false;
    }

}
