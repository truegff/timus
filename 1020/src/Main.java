import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int N;
        double R,length=0;

        StringTokenizer stk = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stk.nextToken());
        R = Double.parseDouble(stk.nextToken());
        
        double [][] coords = new double[N][2];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bufferedReader.readLine());
            coords[i][0] = Double.parseDouble(stk.nextToken());
            coords[i][1] = Double.parseDouble(stk.nextToken());
        }
        
        for (int i=0;i<N-1; i++) {
            length += Math.sqrt(Math.pow(coords[i][0]-coords[i+1][0],2)+Math.pow(coords[i][1]-coords[i+1][1],2));    
        }
        if (N>1)
        length += Math.sqrt(Math.pow(coords[0][0]-coords[N-1][0],2)+Math.pow(coords[0][1]-coords[N-1][1],2));

        length+=2*Math.PI*R;

        DecimalFormat df = new DecimalFormat("#.##");

        printWriter.println(df.format(length));

        printWriter.flush();
    }

}
