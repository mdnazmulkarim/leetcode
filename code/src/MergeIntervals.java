import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{8,10},{15,18},{1,3},{2,6},};
        new MergeIntervals().merge(arr);

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0]- b[0]);
        List<int[]> list = new ArrayList<>() ;

        list.add(intervals[0]);

        int index = 0;
        if(intervals.length>1) {
           for(int i=1; i< intervals.length; i++) {
               if(intervals[i][0] <= list.get(index)[1]) {
                   list.set(index, merge(intervals[i], list.get(index)));
               }else {
                   list.add(intervals[i]);
                   index++;
               }
           }
        }

         for(int j=0; j< list.size(); j++) {
            System.out.println(list.get(j)[0]+ "-"+ list.get(j)[1]);
        }

        return list.toArray(new int[list.size()][]);
    }

    int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0],b[0]), Math.max(a[1], b[1])};
    }
}
