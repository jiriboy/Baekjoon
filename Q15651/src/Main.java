import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] seq;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[M];

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solve(0);

        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int order) throws Exception {
        if (order == M) {
            for (int i = 0; i < M; i++) {
                bw.write(seq[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            seq[order] = i;
            Solve(order + 1);
        }
    }
}
