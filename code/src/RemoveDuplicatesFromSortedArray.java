import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        //int[] arr = new int[]{1,1,2,2,2,3,4,4};
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {

        int targetIndex = 1;
        int targetValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != targetValue) {
                nums[targetIndex] = nums[i];
                targetIndex++;
                targetValue = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));

        return targetIndex;
    }
}
