import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = Integer.parseInt(bufferedReader.readLine());

        String str;
        int x, y;
        for (int i=0; i<n; i++) {
            str = bufferedReader.readLine();
            y = str.charAt(0)-96;
            x = Integer.parseInt(String.valueOf(str.charAt(1)));

            printWriter.println(getStepAnswer(x, y));
        }
        printWriter.flush();
    }

    public static int getStepAnswer(int x, int y) {
        int stepAnswer = 0;

        if ((x-2)>0 && (y+1)<9) stepAnswer++;
        if ((x-2)>0 && (y-1)>0) stepAnswer++;

        if ((x+2)<9 && (y+1)<9) stepAnswer++;
        if ((x+2)<9 && (y-1)>0) stepAnswer++;

        if ((x-1)>0 && (y-2)>0) stepAnswer++;
        if ((x-1)>0 && (y+2)<9) stepAnswer++;

        if ((x+1)<9 && (y-2)>0) stepAnswer++;
        if ((x+1)<9 && (y+2)<9) stepAnswer++;

        return stepAnswer;
    }

}
