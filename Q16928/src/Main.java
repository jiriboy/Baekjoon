import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] shortest = new int[101];
    static int[] next = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < next.length; i++) {
            next[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            next[from] = to;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(1);

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int to = from + i;

                if (to >= shortest.length) {
                    break;
                }

                to = next[to];

                if (shortest[to] == 0) {
                    queue.add(to);
                    shortest[to] = shortest[from] + 1;
                }
            }
        }

        bw.write(Integer.toString(shortest[100]));
        bw.close();
        br.close();
    }
}