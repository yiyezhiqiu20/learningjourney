import java.util.Scanner;

public class P1045 {
    static final int LEN = 500;

    // 高精度乘法：a = a * 2
    static void mul2(int[] a) {
        int carry = 0;
        for (int i = 0; i < LEN; i++) {
            int t = a[i] * 2 + carry;
            a[i] = t % 10;
            carry = t / 10;
        }
    }

    // 高精度减 1
    static void sub1(int[] a) {
        a[0]--;
        int i = 0;
        while (a[i] < 0) {
            a[i] += 10;
            a[i + 1]--;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        // 第一问：求位数公式：log10(2) * p + 1
        int len = (int) (p * Math.log10(2) + 1);
        System.out.println(len);

        // 第二问：求最后 500 位
        int[] num = new int[LEN];
        num[0] = 1;  // 初始 2^0 = 1

        // 快速幂思想：乘 p 次 2
        for (int i = 0; i < p; i++) {
            mul2(num);
        }

        // 2^p - 1
        sub1(num);

        // 输出：50位一行，共10行，倒序输出
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(num[LEN - 1 - (i * 50 + j)]);
            }
            System.out.println();
        }
    }
}