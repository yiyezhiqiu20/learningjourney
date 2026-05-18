import java.util.Scanner;

public class P1002 {
    // 马的8个走位偏移量
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    // 标记禁走点位
    static boolean[][] ban = new boolean[25][25];
    // dp数组存路径数，用long防止溢出
    static long[][] dp = new long[25][25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int hx = sc.nextInt();
        int hy = sc.nextInt();

        // 标记马自身位置
        ban[hx][hy] = true;
        // 标记马能走到的8个点
        for (int i = 0; i < 8; i++) {
            int x = hx + dx[i];
            int y = hy + dy[i];
            if (x >= 0 && y >= 0 && x <= 20 && y <= 20) {
                ban[x][y] = true;
            }
        }

        // 起点初始化
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 禁止点位直接跳过
                if (ban[i][j]) continue;
                // 从上方走来
                if (i > 0) dp[i][j] += dp[i - 1][j];
                // 从左方走来
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        System.out.println(dp[n][m]);
    }
}