import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int answer;
    static char[][] coin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        coin = new char[N][N];

        for (int i = 0; i < N; i++) {
            coin[i] = br.readLine().toCharArray();
        }

        answer = Integer.MAX_VALUE;

        Solve(0);

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void Solve(int depth) {
        if (depth == N) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                int head = 0;

                for (int j = 0; j < N; j++) {
                    if (coin[i][j] == 'H') {
                        head++;
                    }
                }

                count += Math.min(head, N - head);
            }

            answer = Math.min(answer, count);
            return;
        }

        Solve(depth + 1);

        for (int i = 0; i < N; i++) {
            coin[i][depth] = toggle(coin[i][depth]);
        }

        Solve(depth + 1);
    }

    static char toggle(char c) {
        if (c == 'H') {
            return 'T';
        } else {
            return 'H';
        }
    }
}
