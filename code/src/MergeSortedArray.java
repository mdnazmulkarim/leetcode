import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{6,7,8,0,0,0};   //i=0
        int[] arr2 = new int[]{1,2,3};        //j=3
        new MergeSortedArray().merge(arr1,3, arr2,3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;


        for(int k = m + n - 1; k>=0; k--) {
            if(i>=0 && j>=0){
                nums1[k] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            } else if(i>=0) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
