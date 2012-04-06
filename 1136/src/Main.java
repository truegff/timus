import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Timus 1136 problem solution. (codename PARLIAMENT)
 *
 * @author Alexander Dolidze <alexander.dolidze@gmail.com>
 */
public class Main {

    public static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] deputies = new int[N];
        for (int i = 0; i < N; i++) {
            deputies[i] = sc.nextInt();
        }

        Seat head = new Seat(deputies[N - 1]);
        head.root = true;

        for (int i = N - 2; i >= 0; i--) {
            head.insert(deputies[i]);
        }

        head.printEven();

        printWriter.flush();
    }

}

class Seat {
    int index;
    Seat greater;
    Seat lesser;
    boolean root;

    Seat(int index) {
        this.index = index;
    }

    public void insert(int index) {
        if (index < this.index) {
            if (lesser == null) lesser = new Seat(index);
            else lesser.insert(index);
        } else {
            if (greater == null) greater = new Seat(index);
            else greater.insert(index);
        }
    }

    public void printEven() {
        if (greater != null) greater.printEven();
        if (lesser != null) lesser.printEven();
        if (root)
            Main.printWriter.println(index);
        else
            Main.printWriter.print(index + " ");
    }
}