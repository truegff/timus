import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = Integer.parseInt(bufferedReader.readLine());
        int arr[][] = new int[n][n];
        
        int ctr=1;

        int x=0,y=0;
        for (int i=n-1; i>=0; i--) {
            x=i;
            y=0;
            while (y<n-i) {
                arr[y][x] = ctr++;
                x+=1;
                y+=1;
            }
        }
        for (int i=1; i<n; i++) {
            x=0;
            y=i;
            while (x<n-i) {
                arr[y][x] = ctr++;
                x+=1;
                y+=1;
            }
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j!=0) printWriter.print(" ");
                printWriter.print(arr[i][j]);
            }
            printWriter.println();
        }

        printWriter.flush();
    }
}
