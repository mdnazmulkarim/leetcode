import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,2,2,2,3};
        System.out.println(new RemoveDuplicates().removeDuplicates(arr));
    }

    //1,1,1,2,2,2,3
    //1,1,2,2,3

    public int removeDuplicates(int[] nums) {
        int currentItem = nums[0];
        int toBeFilledIndex = 1;
        int currentOccurance = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == currentItem) {
                currentOccurance++;
                if(currentOccurance>2) {

                } else {
                    nums[toBeFilledIndex] = nums[i];
                    toBeFilledIndex++;
                }
            } else {
                currentItem = nums[i];
                nums[toBeFilledIndex] = nums[i];
                toBeFilledIndex++;
                currentOccurance = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return toBeFilledIndex;
    }
}
