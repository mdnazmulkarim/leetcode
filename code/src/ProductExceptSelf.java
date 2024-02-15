import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2 = {1,1,0,-3,3};
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(arr2)));
    }

    public int[] productExceptSelf(int[] nums) {

        if(nums.length ==1) {
            return nums;
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length];

        int rightMul = 1;
        int leftMul = 1;

        int i =1;
        while (i<nums.length) {
            rightMul *= nums[nums.length-i];
            right[nums.length-i] = rightMul;
            leftMul *= nums[i-1];
            left[i-1] = leftMul;
            i++;
        }

        for(int j=0; j<nums.length; j++) {
            if(j==0 && nums.length > 1) {
                result[j] = 1* right[j+1];
            }
            else if(nums.length>1 && j == (nums.length-1)) {
                result[j] = left[j-1] * 1;
            } else {
                result[j] = left[j-1] * right[j+1];
            }
        }

        return result;
    }
}
