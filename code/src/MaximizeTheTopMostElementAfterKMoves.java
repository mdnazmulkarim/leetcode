public class MaximizeTheTopMostElementAfterKMoves {

    public static void main(String[] args) {
        int[] arr = new int[]{91, 98, 117, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60 };

        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr, 2));
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr, 5));

        int[] arr2 = new int[]{ 4, 8, 9, 91, 98 };
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr2, 2));
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr2, 5));
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr2, 7));

        int[] arr3 = new int[]{ 4 };
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr3, 6));
        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr3, 7));

        int[] arr4 = new int[]{91, 98, 17, 79, 15, 55, 47, 86, 4, 5, 17, 79, 68, 60, 60, 31, 72, 85, 25, 77, 8, 78, 40, 96, 76, 69, 95, 2, 42, 87, 48, 72, 45, 25, 40, 60, 21, 91, 32, 79, 2, 87, 80, 97, 82, 94, 69, 43, 18, 19, 21, 36, 44, 81, 99};

        System.out.println(new MaximizeTheTopMostElementAfterKMoves().maximumTop(arr4, 2));

    }

    public int maximumTop(int[] nums, int k) {

        int max = -1;
        if(k ==0) {
            max = nums[0];
        } else if(nums.length ==1) {
            if (k % 2 == 0) {
                max = nums[0];
            }
        } else if(k> nums.length) {
            int i=0;

            while(i<nums.length) {
                if(nums[i]> max) {
                    max = nums[i];
                }
                i++;
            }
        } else if (nums.length >= k) {
            int i=0;

            while(i<(k-1)) {
                if(nums[i]> max) {
                    max = nums[i];
                }
                i++;
            }

            if(nums.length> k && nums[k]> max) {
                max = nums[k];
            }
        }

        return max;
    }

}
