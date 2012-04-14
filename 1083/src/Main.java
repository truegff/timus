import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        String[] tokens = bufferedReader.readLine().split("[ ]");
        int n = Integer.parseInt(tokens[0]);
        int k = tokens[1].length();

        int ans = 1;
        int mod = n%k;
        if (mod != 0) {
            do {
                ans *= n;
                n -= k;
            } while (n>=mod);
        } else {
            do {
                ans *= n;
                n-=k;
            } while (n>0);
        }

        printWriter.println(ans);
        printWriter.flush();
    }
}
