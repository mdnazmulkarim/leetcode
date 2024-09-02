import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(arr));

    }
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        return map.size() == (map.values().stream().collect(Collectors.toSet()).size());
    }
}
