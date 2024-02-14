import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Comparator;

public class BurstBaloonMinArrow {
    public static void main(String[] args) {

        //int[][] arr = new int[][]{{10,16},{1,6},{7,12},{2,8}};
        int[][] arr = new int[][]{{1,2},{3,4},{5,7},{7,8}};
        System.out.println(new BurstBaloonMinArrow().findMinArrowShots(arr));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int start = points[0][0];
        int end = points[0][1];

        int noOfArrows = 1;

        for(int i=1; i<points.length; i++) {
            if(points[i][0] <= end) {
                start = Math.max(start, points[i][0]);
                end = Math.min(end, points[i][1]);
            }
             else {
                 start = points[i][0];
                 end = points[i][1];
               noOfArrows++;
           }
        }

        return noOfArrows;
    }
}
