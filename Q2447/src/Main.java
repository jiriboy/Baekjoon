import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static char[][] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        answer = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], ' ');
        }

        solve(0, 0, N);

        for (int i = 0; i < N; i++) {
            bw.write(answer[i]);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static void solve(int x, int y, int len) {
        if (len == 1) {
            answer[x][y] = '*';
            return;
        }

        len /= 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                solve(x + i * len, y + j * len, len);
            }
        }
    }
}
