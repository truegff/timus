import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static int max[][] = new int[100001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        max[0][0] = 0;
        max[0][1] = 0;
        max[1][0] = 1;
        max[1][1] = 1;

        for (int i = 2; i < 100001; i++) {
            if (i % 2 == 0) {
                max[i][0] = max[i / 2][0];
            } else {
                max[i][0] = max[(i - 1) / 2][0] + max[(i - 1) / 2 + 1][0];
            }
            max[i][1] = Math.max(max[i][0], max[i - 1][1]);
        }

        int reading;

        while ((reading = Integer.parseInt(bufferedReader.readLine())) != 0) {
            printWriter.println(max[reading][1]);
        }

        printWriter.flush();
    }
}
