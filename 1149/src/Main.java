import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class Main {

    public static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        Sn(1, N);
        printWriter.println();

        printWriter.flush();
    }
    
    public static void An(int ctr, int n) {
        String str = "";
        if (ctr == n) {
            printWriter.print("sin("+ctr+")");
            return;
        }
        printWriter.print("sin("+ctr+sign(ctr));
        An(ctr+1, n);
        printWriter.print(")");
        return;
    }
    
    public static void Sn(int ctr, int n) {
        if (ctr == n) {
            An(1,1);
            printWriter.print("+"+n);
            return;
        }
        
        printWriter.print("(");
        Sn(ctr+1,n);
        printWriter.print(")");
        An(1,n-ctr+1);
        printWriter.print("+"+ctr);
    }

    public static char sign(int i) {
        if (i%2 == 0) return '+'; else return '-';
    }

}
