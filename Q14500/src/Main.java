import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int sum = 0;
    static int answer = 0;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Solve1(i, j, 0, -1);
                Solve2(i, j);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve1(int x, int y, int count, int from) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return;
        }

        count++;
        sum += map[x][y];

        if (count == 4) {
            if (sum > answer) {
                answer = sum;
            }

            sum -= map[x][y];
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (i == 0 && from == 1 || i == 1 && from == 0 || i == 2 && from == 3 || i == 3 && from == 2) {
                continue;
            }

            Solve1(x + dx[i], y + dy[i], count, i);
        }

        sum -= map[x][y];
    }

    static void Solve2(int x, int y) {
        if (x > 0 && x < N - 1 && y > 0) {
            answer = Math.max(answer, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1]);
        }

        if (x > 0 && x < N - 1 && y < M - 1) {
            answer = Math.max(answer, map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y + 1]);
        }

        if (x > 0 && y > 0 && y < M - 1) {
            answer = Math.max(answer, map[x][y] + map[x - 1][y] + map[x][y - 1] + map[x][y + 1]);
        }

        if (x < N - 1 && y > 0 && y < M - 1) {
            answer = Math.max(answer, map[x][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1]);
        }
    }
}
