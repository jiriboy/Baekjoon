import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        int[][][] shortest = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        LinkedList<State> queue = new LinkedList<>();

        queue.add(new State(0, 0, 0, 1));
        shortest[0][0][0] = 1;

        int answer = -1;

        while (!queue.isEmpty()) {
            State s = queue.poll();

            if (s.x == N - 1 && s.y == M - 1) {
                answer = s.d;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = s.x + dx[i];
                int y = s.y + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                if (map[x][y] == '0' && (shortest[x][y][s.w] == 0 || shortest[x][y][s.w] > s.d + 1)) {
                    queue.add(new State(x, y, s.w, s.d + 1));
                    shortest[x][y][s.w] = s.d + 1;
                }

                if (map[x][y] == '1' && s.w < K && (shortest[x][y][s.w + 1] == 0 || shortest[x][y][s.w + 1] > s.d + 1)) {
                    queue.add(new State(x, y, s.w + 1, s.d + 1));
                    shortest[x][y][s.w + 1] = s.d + 1;
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static class State {
        int x;
        int y;
        int w;
        int d;

        State(int x, int y, int w, int d) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.d = d;
        }
    }
}
