public class MinimumSwaps {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(minimumSwaps(nums));
    }

    public static int minimumSwaps(int[] nums) {

        int maxIndex = 0;
        int max = nums[maxIndex];
        int minIndex = nums.length-1;
        int min = nums[nums.length-1];
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i+1] >= max) {
                maxIndex = i+1;
                max = nums[i+1];
            }
        }
        System.out.println("MaxIndex : " + maxIndex);


        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] <= min) {
                minIndex = i;
                min = nums[i];
            }
        }

        System.out.println("MinIndex : " + minIndex);

        int total = (nums.length-1) - maxIndex + minIndex ;

        if(minIndex > maxIndex) {
            total = total -1;
        }

        return total;
    }
}
