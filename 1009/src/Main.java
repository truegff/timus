import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        N = Integer.parseInt(bufferedReader.readLine());
        K = Integer.parseInt(bufferedReader.readLine());

//        2 ≤ K ≤ 10; N ≥ 2; N + K ≤ 18.

        if (N==1) printWriter.println(K);
        else printWriter.println(calculate(1, true));

        printWriter.flush();
    }

    public static long calculate(long step, boolean previousWasZero) {
        if (step == N) {
            if (previousWasZero) {
                return K - 1;
            } else {
                return K;
            }
        } else {
            if (previousWasZero) {
                return (K - 1) * calculate(step + 1, false);
            } else {
                long variantA = calculate(step + 1, true);
                long variantB = (K - 1) * calculate(step + 1, false);
                return variantA + variantB;
            }
        }
    }

}
