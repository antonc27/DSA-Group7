import java.util.ArrayList;
import java.util.List;

public class W02_PrintingPatterns {
    public static void trianglePattern1(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                count++;
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }

    public static void trianglePattern2(int n) {
        List<List<Integer>> pattern = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        pattern.add(first);
        for (int i = 1; i <= n; i++) {
            List<Integer> previous = pattern.get(i-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(previous.get(j-1) + previous.get(j));
            }
            current.add(1);
            pattern.add(current);
        }

        for (List<Integer> line : pattern) {
            for (Integer i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //trianglePattern1(5);
        trianglePattern2(5);
    }
}
