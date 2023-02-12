public class FindFirstAndLastPosInASortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,5,6,7,7,7,7,8};
        new FindFirstAndLastPosInASortedArray().searchRange(arr,2);
        new FindFirstAndLastPosInASortedArray().searchRange(arr,3);
        new FindFirstAndLastPosInASortedArray().searchRange(arr,3);
        new FindFirstAndLastPosInASortedArray().searchRange(arr,7);
       // System.out.println(arr.length);
        new FindFirstAndLastPosInASortedArray().searchRange(arr,8);
    }
    public int[] searchRange(int[] nums, int target) {

        int index = nums.length/2 -1;

        int i=0;
        while(index>=0 && index< nums.length && i<10) {
            i++;
            if(nums[index] > target) {
                index = index - index / 2;
                //System.out.println("left:" + index);
            } else if(nums[index] < target) {
                index = index + (nums.length - index) / 2;
                //System.out.println("right" + index);
            }
            else if(nums[index] == target) {
                break;
            }
        }
        System.out.println(index);

        return new int[]{-1,-1};
    }
}
