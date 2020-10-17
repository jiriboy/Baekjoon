import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        seq = new int[m];

        Solve(0);
    }

    static void Solve(int m) {
        if (m == seq.length) {
            for (int i = 0; i < m - 1; i++) {
                System.out.print(seq[i] + " ");
            }
            System.out.println(seq[m - 1]);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[m] = i + 1;
                Solve(m + 1);
                visited[i] = false;
            }
        }
    }
}
