import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] seq;
    static int[] op;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];

        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        Solve(seq[0], 1);

        bw.write(max + "\n" + min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int result, int index) {
        if (index == N) {
            if (result > max) {
                max = result;
            }

            if (result < min) {
                min = result;
            }

            return;
        }

        if (op[0] > 0) {
            op[0]--;
            Solve(result + seq[index], index + 1);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            Solve(result - seq[index], index + 1);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            Solve(result * seq[index], index + 1);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            Solve(result / seq[index], index + 1);
            op[3]++;
        }
    }
}
