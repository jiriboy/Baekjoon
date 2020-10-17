import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] seq;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        visited = new boolean[N];

        Solve(0);
    }

    static void Solve(int order) {
        if (order == M) {
            for (int i = 0; i < M - 1; i++) {
                System.out.print(seq[i] + " ");
            }
            System.out.println(seq[M - 1]);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (order == 0 || !visited[i] && order > 0 && i + 1 > seq[order - 1]) {
                seq[order] = i + 1;
                visited[i] = true;
                Solve(order + 1);
                visited[i] = false;
            }
        }
    }
}
