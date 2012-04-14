import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int N = Integer.parseInt(bufferedReader.readLine());

        long[] primes = new long[15001];
        int ctr = 0;

        for (long i = 2; ctr < 15000 && i<Long.MAX_VALUE; i++) {
            if (phi(i)==i-1) primes[++ctr] = i;
        }

        int req = 0;
        for (int i=0; i<N; i++) {
            req = Integer.parseInt(bufferedReader.readLine());
            printWriter.println(primes[req]);
        }
        printWriter.flush();
    }

    public static long phi(long n) {
        long result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                result -= result / i;
            }
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

}
