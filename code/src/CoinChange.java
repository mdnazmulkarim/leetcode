import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {

        int[] coins = new int[]{1,2,5};
        int[] coins2 = new int[]{1,5,6,9};
        System.out.println(new CoinChange().coinChange(coins, 11));
        System.out.println(new CoinChange().coinChangeDp(coins, 11));
        System.out.println(new CoinChange().coinChange(coins2, 11));
    }
    // 1,5,6,9   = 11
    // 1,2,5  = 11

    public int coinChange(int[] coins, int amount) {

        Integer[] mem = new Integer[amount + 1];
        return recursiveHelper(mem, coins, amount);

    }

    private int recursiveHelper(Integer[] mem, int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }

        if(mem[amount] != null) {
            return mem[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount >= coin) {
                int temp = coinChange(coins, amount - coin);
                if(temp == -1) {
                    continue;
                }

                minCoins = Math.min(minCoins, 1+ temp);
            }
        }
        mem[amount] = minCoins;
        return minCoins == Integer.MAX_VALUE? -1: minCoins;
    }

    public int coinChangeDp(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int val = 1; val <= amount; val++) {
            for (int coin : coins) {
                int index = val - coin;
                if (index < 0) continue;
                dp[val] = Math.min(dp[val], 1 + dp[val - coin]);
            }

        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
