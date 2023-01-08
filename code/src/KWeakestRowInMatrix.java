import java.util.*;

public class KWeakestRowInMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}};

        int[][] arr2 = {{1,0,0,0},
        {1,1,1,1},
            {1,0,0,0},
                {1,0,0,0}};

        System.out.println(Arrays.toString(new KWeakestRowInMatrix().kWeakestRows(arr2,2)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        Map<Integer, ArrayItem> map = new HashMap<Integer, ArrayItem>();
        int[] retMat = new int[k];


        for(int row =0; row <mat.length; row++) {
            ArrayItem arrayItem = new ArrayItem(row, 0);
            for(int col = 0; col < mat[0].length; col++) {
                if(mat[row][col] == 1) {
                    arrayItem.setFrequency(arrayItem.getFrequency() + 1);
                }
            }
            map.put(row, arrayItem);
        }

        List<ArrayItem> list = new ArrayList<ArrayItem>(map.values());

        Collections.sort(list, new SortByFrequency());

        for(int i=0; i<k; i++) {
            retMat[i] = list.get(i).getIndex();
        }

        return retMat;
    }


    class ArrayItem {

        int index;
        int frequency; // of 1

        public ArrayItem(int val, int freq) {
            this.index = val;
            this.frequency = freq;
        }

        public int getIndex() { return this.index; }
        public void setIndex( int val) { this.index = val; }

        public int getFrequency() { return this.frequency; }
        public void setFrequency( int freq) { this.frequency = freq; }
    }

    class SortByFrequency implements Comparator<ArrayItem> {

        public int compare(ArrayItem a, ArrayItem b) {
            return a.frequency - b.frequency;
        }
    }
}