import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class Main {

    public static HashSet<Long> positions = new HashSet<Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        long pos = 1;
        for (int i=0; pos<=2147483647; i++) {
            positions.add(new Long(pos));
            pos+=i;
        }
        long N = Integer.parseInt(bufferedReader.readLine());
        long req;
        for (int i = 0; i < N; i++) {
            req = Long.parseLong(bufferedReader.readLine());
            if (i > 0) printWriter.print(" ");
            printWriter.print(positions.contains(new Long(req)) ? "1" : "0");
        }

        printWriter.flush();
    }

}
