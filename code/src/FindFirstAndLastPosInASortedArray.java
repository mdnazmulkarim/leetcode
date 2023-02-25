public class FindFirstAndLastPosInASortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,5,6,7,7,7,7,8};
        new FindFirstAndLastPosInASortedArray().searchRange(arr,7);
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums,target), findLast(nums,target)};
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
