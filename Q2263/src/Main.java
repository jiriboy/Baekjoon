import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int[] in;
    static int[] post;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        in = new int[N];
        post = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, N - 1, 0, N - 1);

        bw.close();
        br.close();
    }

    static void solve(int in_start, int in_end, int post_start, int post_end) throws Exception {
        if (in_start > in_end) {
            return;
        }

        int root = post[post_end];

        bw.write(root + " ");

        for (int i = in_start; i <= in_end; i++) {
            if (in[i] == root) {
                solve(in_start, i - 1, post_start, post_start + i - in_start - 1);
                solve(i + 1, in_end, post_start + i - in_start, post_end - 1);
                break;
            }
        }
    }
}
