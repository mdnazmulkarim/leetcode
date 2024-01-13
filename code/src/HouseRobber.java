

public class HouseRobber {
    public static void main(String[] args) {
      int[] nums = new int[]{12};
      int[] nums2 = new int[]{1,2,3,1};
      int[] nums3 = new int[]{2,1,1,2};
        System.out.println(new HouseRobber().rob(nums));
        System.out.println(new HouseRobber().rob(nums2));
        System.out.println(new HouseRobber().rob(nums3));
    }

    /*
    public int rob(int[] nums) {

        int odds = 0;
        int evens = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
                odds = odds + nums[i];
            } else {
                evens = evens + nums[i];
            }
        }
        return Math.max(odds, evens);
    }

    */

    public int rob(int[] nums) {
        int[] arr = new int[nums.length+1];

        arr[nums.length] = 0;
        arr[nums.length-1] = nums[nums.length-1];

        for(int i = nums.length-2; i>=0; i-- ) {
            arr[i] = Math.max(arr[i+2] + nums[i], arr[i+1]);
            System.out.println("arr:"+i+":"+arr[i]);
        }

        return arr[0];
    }
}
