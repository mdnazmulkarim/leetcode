public class FindTheHighestAltitude {
    public static void main(String[] args) {
        FindTheHighestAltitude instance = new FindTheHighestAltitude();
        System.out.println(instance.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(instance.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int max = currentAltitude;

        for(int i : gain) {
            currentAltitude = currentAltitude + i;
            max = Math.max(max, currentAltitude);
        }

        return max;
    }
}
