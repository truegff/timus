import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Timus problem # 1329 (Galactic History)
 *
 * @author Alexander Dolidze <alexander.dolidze@gmail.com>
 */
public class Main {

    static int dfsStepCounter = 0;

    public static void main(String... args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        int nMilestones = Integer.parseInt(bufferedReader.readLine());

        int in, p;
        String tokens[];

        int rootNodeIndex = 0;
        for (int i = 0; i < nMilestones; i++) {
            tokens = bufferedReader.readLine().split("[ ]+");
            in = Integer.parseInt(tokens[0]);
            p = Integer.parseInt(tokens[1]);

            if (p == -1) rootNodeIndex = in;
            MilestoneFactory.getNode(in).setParent(MilestoneFactory.getNode(p));
        }

        dfs(MilestoneFactory.getNode(rootNodeIndex));


        int result;
        int nRequests = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < nRequests; i++) {
            tokens = bufferedReader.readLine().split("[ ]+");
            result = 0;

            Milestone a = MilestoneFactory.getNode(Integer.parseInt(tokens[0]));
            Milestone b = MilestoneFactory.getNode(Integer.parseInt(tokens[1]));

            if (a.getDiscovered() < b.getDiscovered() && a.getFinished() > b.getFinished()) result = 1;
            else if (a.getDiscovered() > b.getDiscovered() && a.getFinished() < b.getFinished()) result = 2;
            else result = 0;

            printWriter.println(result);

            //1, if milestone A is a root of subtree which contains milesone B.
            //2, if milestone B is a root of subtree which contains milesone A.
            //0, if no one of the first two conditions is true.

        }
        printWriter.flush();
    }

    private static void dfs(Milestone node) {
        node.setDiscovered(dfsStepCounter++);
        for (Milestone m : node.getChildren()) {
            dfs(m);
        }
        node.setFinished(dfsStepCounter++);
    }
}

class Milestone {
    private Milestone parent;
    private ArrayList<Milestone> children = new ArrayList<Milestone>();
    private int discovered;

    public int getDiscovered() {
        return discovered;
    }

    public ArrayList<Milestone> getChildren() {

        return children;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    int finished;
    private int index;

    public void setParent(Milestone parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    private void addChild(Milestone milestone) {
        this.children.add(milestone);
    }

    public Milestone(int index) {
        this.index = index;
    }

    public void setDiscovered(int i) {
        this.discovered = i;
    }
}

class MilestoneFactory {
    private static HashMap<Integer, Milestone> milestones = new HashMap<Integer, Milestone>();

    public static Milestone getNode(int index) {
        if (!milestones.containsKey(new Integer(index))) milestones.put(new Integer(index), new Milestone(index));
        return milestones.get(new Integer(index));
    }
}


//// Sample input:
//10
//234 -1
//12 234
//13 234
//14 234
//15 234
//16 234
//17 234
//18 234
//19 234
//233 19
//5
//234 233
//233 12
//233 13
//233 15
//233 19
//
//// Expected output
//1
//0
//0
//0
//2