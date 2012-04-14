import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        long n = Long.parseLong(bufferedReader.readLine());

        
        if (n==1) printWriter.println(1);
        else
        if (n==0) printWriter.println(10);
        else printWriter.println(calculateAnswer(n, 0, 1));

        printWriter.flush();
    }

    public static long calculateAnswer(long n, long answer, long depth) {
        if (n!=0)
        for (int i=9; i>1; i--) {
            if (n==i) return answer+i*depth;
            if (n%i==0) {
                return calculateAnswer(n/i, answer+i*depth, depth*10);
            }  
        };    
        return -1;
    }
}
