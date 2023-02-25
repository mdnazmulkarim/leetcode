public class UniquePaths {
    public static void main(String[] args) {

        System.out.println(new UniquePaths().uniquePaths(4,6));
    }

    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int R = Math.min(m - 1, n - 1);
        int temp = R;
        double result = 1;
        for (int i = 0; i < temp; i++) {
            result = (result * N--) / R--;
        }
        return (int) Math.round(result);
    }
}
