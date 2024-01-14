public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(8));
        System.out.println(new ClimbStairs().climbStairsDp(8));
    }

    public int climbStairs(int n) {

        int[] mem = new int[n+1];
        return climbStairs(0,n,mem);
    }

    public int climbStairs(int from, int n, int[] mem ) {

        if(from > n) {
            return 0;
        }
        if(from == n) {
            return 1;
        }

        if(mem[from] != 0) {
            return mem[from];
        }

        mem[from] = climbStairs(from+1, n, mem) + climbStairs(from +2, n, mem);

        return mem[from];
    }

    public int climbStairsDp(int n) {
        int[] dp = new int[n+1];

        dp[n] = 1;
        dp[n-1] =1;

        for(int i = n-2; i>=0; i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }


}
