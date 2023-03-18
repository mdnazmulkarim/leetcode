import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};
        new Subsets().subsets(arr);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        long n = (long)Math.pow(2,nums.length);

        for(long i=0; i<n; i++) {
            String binString = getPaddedBinaryString(nums.length, i);
            System.out.println(binString);

            List<Integer> l = new ArrayList();
            for (int j = 0; j < binString.length(); j++) {
                if (binString.charAt(j) == '1') {
                    l.add(nums[j]);
                }
            }
            System.out.println("adding:" + l);
            list.add(l);
        }
        System.out.println(list);
        return list;
    }

    private String getPaddedBinaryString(int l, long i) {
        String str = Long.toBinaryString(i);

        int length = l - str.length();
        char[] padArray = new char[length];
        Arrays.fill(padArray, '0');
        String padString = new String(padArray);
        String binString = padString + str;

        return binString;
    }
}
