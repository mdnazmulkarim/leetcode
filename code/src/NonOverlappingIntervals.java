import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {

        //int arr[][] = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        //int arr[][] = new int[][]{{1,2},{1,2},{1,2}};
        //int arr[][] = new int[][]{{1,2},{2,3}};
        int[][] arr = new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(arr));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int ans = 0;
        int prev = Integer.MIN_VALUE;

        for(int[] arr : intervals) {
            if(arr[0] >= prev) {
                prev = arr[1];
            } else {
                ans++;
            }
        }

        return ans;
    }
}
