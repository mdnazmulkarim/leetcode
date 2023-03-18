import java.util.*;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {

        //int[][] graph = new int[][]{{1,2},{3},{3},{}};
        int[][] graph = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        new AllPathsFromSourceToTarget().allPathsSourceTarget(graph);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Map<Integer, List<Integer>> map =  new HashMap<>();
        int start =0;
        int target = 0;

        for(int i= 0; i< graph.length; i++) {
            for(int j=0; j< graph[i].length; j++) {
                if(!map.containsKey(graph[i][j])) {
                    map.put(graph[i][j], new ArrayList<>());
                }
                map.get(graph[i][j]).add(i);
            }
            target = i;
        }
        System.out.println(map);

        List<List<Integer>> paths = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();

        int finalTarget = target;
        map.get(target).forEach(i -> {
            q.add(new ArrayList<>() {{
                add(i);
                add(finalTarget);
            }});
        });
        System.out.println(q);

        boolean completed = false;
        while(!q.isEmpty() && ! completed) {

            List list = q.poll();

            if (list != null) {

                if (list.get(0).equals(start) && list.get(list.size() - 1).equals(target)) {
                    paths.add(list);
                } else {
                    if (map.containsKey(list.get(0))) {
                        map.get(list.get(0)).forEach(i -> {
                            if (!list.contains(i)) {
                                List l = new ArrayList();
                                l.addAll(list);
                                l.add(0, i);
                                q.add(l);
                            }
                        });
                    }
                }
            }
        }

        return paths;
    }
}
