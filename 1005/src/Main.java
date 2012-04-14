import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    public static int minSum = Integer.MAX_VALUE;
    public static int n;
    public static int weights[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        n = Integer.parseInt(bufferedReader.readLine());
        weights = new int[n];

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(stk.nextToken());
        }

        testSums(0, 0, 0);

        printWriter.println(minSum);
        printWriter.flush();
    }

    public static void testSums(int step, int sum1, int sum2) {
        if (step == n) {
            minSum = Math.min(minSum, Math.abs(sum1 - sum2));
        } else {
            testSums(step+1, sum1 + weights[step], sum2);
            testSums(step+1, sum1, sum2 + weights[step]);
        }
    }
}
