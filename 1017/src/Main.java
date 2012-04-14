import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//UNFINISHED
public class Main {

    public static long variant = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int N = Integer.parseInt(bufferedReader.readLine());
        calculate(N, 1);

        printWriter.flush();
    }

    public static void calculate(int N, int currentHeight) {
        int lc = 0;
        int maxCurrent;
        if (currentHeight != 1) { //if not on first stair
            if (currentHeight * 2 + 1 == N); // variant++;
            if (currentHeight * 2 + 1 > N); // variant++;
        }
        if (currentHeight * 2 + 1 < N) {
            if (N % 2 == 0) maxCurrent = (N - 2) / 2;
            else maxCurrent = (N - 1) / 2;
            variant += maxCurrent - currentHeight;
        }
        for (; (currentHeight * 2) + 1 <= N; currentHeight++) {
            calculate(N - currentHeight, currentHeight + 1);
            lc += 1;
        }
        if (lc > 0) variant *= lc;
    }

}
