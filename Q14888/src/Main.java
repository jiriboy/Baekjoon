import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] seq;
    static int[] ops;
    static int max;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        DFS(seq[0], 0);

        bw.write(max + "\n" + min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int num, int index) {
        if (index == seq.length - 1) {
            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) {
                continue;
            }

            ops[i]--;

            if (i == 0) {
                DFS(num + seq[index + 1], index + 1);
            } else if (i == 1) {
                DFS(num - seq[index + 1], index + 1);
            } else if (i == 2) {
                DFS(num * seq[index + 1], index + 1);
            } else {
                DFS(num / seq[index + 1], index + 1);
            }

            ops[i]++;
        }
    }
}
