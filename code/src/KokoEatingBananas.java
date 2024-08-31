public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr = new int[]{30,11,23,4,20};
        System.out.println(new KokoEatingBananas().minEatingSpeed(arr,6));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 1;
        for(int pile : piles) {
            max = Math.max(max,pile);
        }
        int left  = 1;
        int right = max;
        System.out.println(max);

        int mid = (left+right)/2;
        while(left < right) {
            if(canEatWithSpeed(piles,mid, h)) {
                right = mid;
            }else {
                left = mid + 1;
            }
            mid = (left+right)/2;
        }
        return right;
    }

    boolean canEatWithSpeed(int[] piles, int speed, int h) {
        int totalSpent = 0;
        for(int pile : piles){
            totalSpent += Math.ceil(Double.valueOf(pile)/speed);
            if(totalSpent > h) {
                return false;
            }
        }
        return true;
    }
        public int minEatingSpeedNaive(int[] piles, int h) {

        int speed = 1;
        int totalSpent = 0;


        while(true) {
            for(int pile : piles){
                totalSpent += Math.ceil(Double.valueOf(pile)/speed);
                if(totalSpent > h) {
                    break;
                }
            }
            if(totalSpent<=h) {
                return speed;
            } else {
                totalSpent = 0;
                speed++;
            }
        }
    }
}
