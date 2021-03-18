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

        answer = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], ' ');
        }

        solve(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            bw.write(answer[i]);
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static void solve(int x, int y, int h) {
        if (h == 3) {
            answer[x][y] = '*';
            answer[x + 1][y - 1] = '*';
            answer[x + 1][y + 1] = '*';
            answer[x + 2][y - 2] = '*';
            answer[x + 2][y - 1] = '*';
            answer[x + 2][y] = '*';
            answer[x + 2][y + 1] = '*';
            answer[x + 2][y + 2] = '*';
            return;
        }

        h /= 2;

        solve(x, y, h);
        solve(x + h, y - h, h);
        solve(x + h, y + h, h);
    }
}
