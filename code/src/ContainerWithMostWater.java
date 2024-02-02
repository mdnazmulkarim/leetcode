public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] arr = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }

    public int maxArea(int[] height) {

        int minI = 0;
        int maxI = height.length-1;
        int max =0;
        while(minI <= maxI) {
            max = Math.max(max,(maxI-minI)* Math.min(height[minI],height[maxI]));
            if(height[minI]<= height[maxI]) {
                minI++;
            } else {
                maxI--;
            }
        }
        return max;
    }
}
