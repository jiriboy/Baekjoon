import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] words;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (char c : chars) {
                words[i] |= 1 << c - 'A';
            }
        }

        Solve(0, 0);

        bw.write(Integer.toString(answer));

        bw.close();
        br.close();
    }

    static void Solve(int selected, int depth) {
        if (Integer.bitCount(selected) == K) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (Integer.bitCount(selected & words[i]) == Integer.bitCount(words[i])) {
                    count++;
                }
            }

            if (count > answer) {
                answer = count;
            }

            return;
        }

        if (depth == 26) {
            return;
        }

        Solve(selected | (1 << depth), depth + 1);
        Solve(selected, depth + 1);
    }
}
