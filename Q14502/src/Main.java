import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int answer;
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

        Solve(0);

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void Solve(int wall) {
        if (wall == 3) {
            answer = Math.max(answer, simulate());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    Solve(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int simulate() {
        LinkedList<Virus> queue = new LinkedList<>();

        int result = 0;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    result++;
                }

                if (map[i][j] == 2) {
                    queue.add(new Virus(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Virus v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = v.x + dx[i];
                int next_y = v.y + dy[i];

                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) {
                    continue;
                }

                if (!visited[next_x][next_y] && map[next_x][next_y] == 0) {
                    visited[next_x][next_y] = true;
                    queue.add(new Virus(next_x, next_y));
                    result--;
                }
            }
        }

        return result;
    }

    static class Virus {
        int x;
        int y;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
