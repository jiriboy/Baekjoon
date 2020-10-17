import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int answer;
    static boolean[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        answer = 0;
        map = new boolean[N][N];
        visited = new boolean[N];

        Solve(0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int depth) {
        if (depth == N - 1) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }

                if (check(depth, i)) {
                    answer++;
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }

                if (check(depth, i)) {
                    map[depth][i] = true;
                    visited[i] = true;
                    Solve(depth + 1);
                    map[depth][i] = false;
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int x, int y) {
        int tx = x;
        int ty = y;

        while (tx > 0 && ty > 0) {
            tx--;
            ty--;

            if (map[tx][ty]) {
                return false;
            }
        }

        tx = x;
        ty = y;

        while (tx > 0 && ty < N - 1) {
            tx--;
            ty++;

            if (map[tx][ty]) {
                return false;
            }
        }

        tx = x;
        ty = y;

        while (tx < N - 1 && ty > 0) {
            tx++;
            ty--;

            if (map[tx][ty]) {
                return false;
            }
        }

        tx = x;
        ty = y;

        while (tx < N - 1 && ty < N - 1) {
            tx++;
            ty++;

            if (map[tx][ty]) {
                return false;
            }
        }

        return true;
    }
}
