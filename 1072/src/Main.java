import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Timus problem # 1072 (Routing)
 *
 * @author Alexander Dolidze <alexander.dolidze@gmail.com>
 */
public class Main {

    public static int depth = 1;

    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        String[] tokens, strIp, strMask;
        tokens = bufferedReader.readLine().split("[ ]+");

        int N = Integer.parseInt(tokens[0]);

        ComputerFactory.init(N);

        int[] ip = new int[4];
        int[] mask = new int[4];

        for (int i = 0; i < N; i++) {
            int subnets = Integer.parseInt(bufferedReader.readLine().split("[ ]+")[0]);
            for (int j = 0; j < subnets; j++) {
                tokens = bufferedReader.readLine().split("[ ]+");
                strIp = tokens[0].split("[.]");
                strMask = tokens[1].split("[.]");

                String subnet = "";
                for (int k = 0; k < 4; k++) {
                    ip[k] = Integer.parseInt(strIp[k]);
                    mask[k] = Integer.parseInt(strMask[k]);
                    subnet += Integer.toBinaryString(ip[k] & mask[k]);
                }

                ComputerFactory.getComputer(i).getSubnets().add(subnet);
            }
        }

        for (Computer c : ComputerFactory.getComputers()) {
            for (Computer d : ComputerFactory.getComputers()) {
                if (c.getIndex() != d.getIndex()) {
                    boolean add = false;
                    for (String subnet : c.getSubnets())
                        if (d.getSubnets().contains(subnet)) add = true;
                    if (add) c.getNeighbors().add(d);
                }
            }
        }

        tokens = bufferedReader.readLine().split("[ ]+");
        int source = Integer.parseInt(tokens[0]) - 1;
        int dest = Integer.parseInt(tokens[1]) - 1;

        dfs(ComputerFactory.getComputer(dest));

        Computer sourceComp = ComputerFactory.getComputer(source);
        if (sourceComp.getParent() == null) printWriter.println("No");
        else {
            printWriter.println("Yes");
            printWriter.print(sourceComp.getIndex() + 1);
            while (true) {
                sourceComp = sourceComp.getParent();
                if (sourceComp == null) break;
                printWriter.print(" " + (sourceComp.getIndex() + 1));
            }
        }

        printWriter.flush();
        printWriter.close();
    }

    private static void dfs(Computer parent) {
        parent.setDepth(depth++);
        for (Computer c : parent.getNeighbors()) {
            if (c.getDepth() == 0) {
                c.setParent(parent);
                dfs(c);
            }
        }
        depth--;
    }
}

class Computer {

    private int index;
    private ArrayList<String> subnets = new ArrayList<String>();
    private ArrayList<Computer> neighbors = new ArrayList<Computer>();

    public Computer getParent() {
        return parent;
    }

    private Computer parent;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    private int depth;


    Computer(int index) {
        this.index = index;
    }

    public ArrayList<String> getSubnets() {
        return subnets;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Computer> getNeighbors() {
        return neighbors;
    }

    public void setParent(Computer parent) {
        this.parent = parent;
    }
}

class ComputerFactory {
    private static Computer[] computers;

    public static void init(int nBases) {
        computers = new Computer[nBases];
        for (int i = 0; i < nBases; i++) computers[i] = new Computer(i);
    }

    public static Computer getComputer(int i) {
        return computers[i];
    }

    public static Computer[] getComputers() {
        return computers;
    }
}
