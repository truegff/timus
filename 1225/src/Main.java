import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        byte N = Byte.parseByte(bufferedReader.readLine());

        Element element = new Element(N);
        System.out.println(element.getSum());
    }
}

class Element {
    Element previous;
    int id;
    long sum = 0;

    Element(int id) {
        this.id = id;
        if (id < 3) sum = 2;
        if (id > 1) previous = new Element(id-1);
    }

    long getSum() {
        if (sum > 0) return sum;
        return sum = previous.getSum()+previous.previous.getSum();
    }
}



