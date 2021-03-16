import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] answer = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.close();
        br.close();
    }

    static void solve(int x, int y, int len) {
        if (check(x, y, len)) {
            return;
        }

        len /= 3;

        for (int i = x; i < x + 3 * len; i += len) {
            for (int j = y; j < y + 3 * len; j += len) {
                solve(i, j, len);
            }
        }
    }

    static boolean check(int x, int y, int len) {
        int num = map[x][y];

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }

        answer[num + 1]++;

        return true;
    }
}
