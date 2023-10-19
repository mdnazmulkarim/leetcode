import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,3,4};
        System.out.println(new MajorityElement().majorityElement(arr));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length/2;
        System.out.println(Arrays.toString(nums));
        int currentValue = nums[0];
        int maxValue = currentValue;
        int maxOccurances = 1;
        int currentOccurances = 1;
        for(int i=1; i< nums.length; i++) {
            if(nums[i] == currentValue) {
                currentOccurances++;
            } else {
                if(currentOccurances> maxOccurances) {
                    maxOccurances = currentOccurances;
                    maxValue = currentValue;
                }
                currentOccurances = 1;
                currentValue = nums[i];

            }
        }
        if(currentOccurances> maxOccurances) {
            maxOccurances = currentOccurances;
            maxValue = currentValue;
        }
        return maxValue;
    }
}
